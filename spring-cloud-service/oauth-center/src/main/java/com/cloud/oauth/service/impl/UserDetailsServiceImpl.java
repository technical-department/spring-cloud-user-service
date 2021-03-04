package com.cloud.oauth.service.impl;
import com.alibaba.fastjson.JSON;
import com.cloud.oauth.config.TokenDecode;
import com.cloud.oauth.dto.SysUser;
import com.cloud.oauth.dto.UserInfo;
import com.cloud.oauth.feign.client.SysUserFeignClient;
import com.cloud.oauth.util.JwtUtil;
import com.cloud.oauth.util.UserJwt;
import com.common.constants.Constants;
import com.common.enums.ResultEnum;
import com.common.exception.BusinessException;
import com.common.response.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bootstrap.encrypt.KeyProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.*;

/*****
 * 自定义授权认证类
 */
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientDetailsService clientDetailsService;

   @Autowired
   private SysUserFeignClient sysUserFeignClient;

    @Resource(name = "keyProp")
    private KeyProperties keyProperties;

    /****
     * 自定义授权认证
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //取出身份，如果身份为空说明没有认证
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //没有认证统一采用httpbasic认证，httpbasic中存储了client_id和client_secret，开始认证client_id和client_secret
        if(authentication==null){
            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(username);
            if(clientDetails!=null){
                //秘钥
                String clientSecret = clientDetails.getClientSecret();
                //静态方式
                //return new User(username,new BCryptPasswordEncoder().encode(clientSecret), AuthorityUtils.commaSeparatedStringToAuthorityList(""));
                //数据库查找方式
                return new User(username,clientSecret, AuthorityUtils.commaSeparatedStringToAuthorityList(""));
            }
        }

        if (StringUtils.isEmpty(username)) {
            return null;
        }

        KeyPair keyPair = new KeyStoreKeyFactory(
                keyProperties.getKeyStore().getLocation(),
                keyProperties.getKeyStore().getSecret().toCharArray())
                .getKeyPair(
                        keyProperties.getKeyStore().getAlias(),
                        keyProperties.getKeyStore().getPassword().toCharArray());


        UserInfo userInfo = new UserInfo();
        userInfo.setUserCode(username);
        userInfo.setExpires_in(Constants.EXPIRES_IN);

        Jwt jwt = JwtHelper.encode(JSON.toJSONString(userInfo), new RsaSigner((RSAPrivateKey)keyPair.getPrivate()));

        R result = null;
        try {
            Map<String, Object> header = new HashMap<>();
            header.put("Authorization", Constants.BEARER  + jwt.getEncoded());

            result = sysUserFeignClient.findByUserCode(header, username);
        } catch (Exception e) {
            log.info("sysUserFeignClient#findByUserCode exception, username={}, e={}", username, e);
        }

        if (result == null) {
            log.info("该用户不存在, username={}", username);
            throw new IllegalArgumentException("该用户不存在");
        }

        if (!ResultEnum.SUCCESS.getCode().equals(result.getCode())) {
            log.info("sysUserFeignClient#findByUserCode exception, username={}, result={}", username, JSON.toJSONString(result));
            throw new IllegalArgumentException(result.getMsg());
        }

        SysUser sysUser = JSON.parseObject(JSON.toJSONString(result.getData()), SysUser.class);
        String permissions = "";
        UserJwt userDetails = new UserJwt(username, sysUser.getUserPwd(), AuthorityUtils.commaSeparatedStringToAuthorityList(permissions));
//        userDetails.setUserName(sysUser.getUserName());
        userDetails.setUserMobile(sysUser.getUserMobile());
        return userDetails;
    }

    private static String httpbasic(String clientId, String clientSecret){
        //将客户端id和客户端密码拼接，按“客户端id:客户端密码”
        String string = clientId + ":" + clientSecret;
        //进行base64编码
        byte[] encode = Base64Utils.encode(string.getBytes());
        return "Basic " + new String(encode);
    }

    public static void main(String[] args) {
        String zhangsan = new BCryptPasswordEncoder().encode("zhangsan");
        System.out.println(zhangsan);
    }
}
