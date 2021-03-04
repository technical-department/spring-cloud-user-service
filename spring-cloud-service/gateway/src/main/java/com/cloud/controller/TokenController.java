package com.cloud.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cloud.feign.Oauth2Client;
import com.cloud.oauth.SystemClientInfo;
//import com.cloud.util.OAuth2Utils;
import com.cloud.vo.LoginVo;
import com.common.response.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//import org.springframework.security.oauth2.common.util.OAuth2Utils;
//import org.springframework.security.oauth2.common.util.OAuth2Utils;

/**
 * 登陆、刷新token、退出
 *
 * @author 小威老师
 */
//@Slf4j
@RestController
public class TokenController {

    @Autowired
    private Oauth2Client oauth2Client;

    /**
     * 系统登陆<br>
     * 根据用户名登录<br>
     * 采用oauth2密码模式获取access_token和refresh_token
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/sys/login")
    public R login(@RequestBody LoginVo vo) {
//    public Map<String, Object> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        Map<String, String> parameters = new HashMap<>();
//        parameters.put(OAuth2Utils.GRANT_TYPE, "password");
//        parameters.put(OAuth2Utils.CLIENT_ID, SystemClientInfo.CLIENT_ID);
//        parameters.put("client_secret", SystemClientInfo.CLIENT_SECRET);
//        parameters.put(OAuth2Utils.SCOPE, SystemClientInfo.CLIENT_SCOPE);

        parameters.put("grant_type", "password");
        parameters.put("client_id", SystemClientInfo.CLIENT_ID);
        parameters.put("client_secret", SystemClientInfo.CLIENT_SECRET);
        parameters.put("scope", SystemClientInfo.CLIENT_SCOPE);


        parameters.put("username", vo.getUsername());
        // 为了支持多类型登录，这里在username后拼装上登录类型
//        parameters.put("username", username + "|" + CredentialType.USERNAME.name());
        parameters.put("password", vo.getPassword());

        Map<String, Object> tokenInfo = null;
        try {
            Map<String, Object> header = new HashMap<>();
            header.put("Authorization", httpbasic(SystemClientInfo.CLIENT_ID, SystemClientInfo.CLIENT_SECRET));

            tokenInfo = oauth2Client.postAccessToken(header, parameters);
            JSONObject jsonObject = JSON.parseObject("{\n" +
                    "        \"id\": \"a75d45a015c44384a04449ee80dc3503\",\n" +
                    "        \"username\": \"jeecg\",\n" +
                    "        \"realname\": \"JEECG用户\",\n" +
                    "        \"avatar\": \"http://minio.jeecg.com/otatest/Screenshot_2021-01-30-06-50-13-648_lockscreen_1614258165409.jpg\",\n" +
                    "        \"birthday\": \"2021-02-25\",\n" +
                    "        \"sex\": 1,\n" +
                    "        \"email\": \"845257580@qq.com\",\n" +
                    "        \"phone\": \"18250262037\",\n" +
                    "        \"orgCode\": \"A01\",\n" +
                    "        \"orgCodeTxt\": null,\n" +
                    "        \"status\": 1,\n" +
                    "        \"delFlag\": 0,\n" +
                    "        \"workNo\": \"A002\",\n" +
                    "        \"post\": \"002\",\n" +
                    "        \"telephone\": null,\n" +
                    "        \"createBy\": \"admin\",\n" +
                    "        \"createTime\": \"2019-02-13 16:02:36\",\n" +
                    "        \"updateBy\": \"jeecg\",\n" +
                    "        \"updateTime\": \"2021-02-26 14:51:06\",\n" +
                    "        \"activitiSync\": 1,\n" +
                    "        \"userIdentity\": 2,\n" +
                    "        \"departIds\": \"c6d7cb4deeac411cb3384b1b31278596\",\n" +
                    "        \"relTenantIds\": \"\",\n" +
                    "        \"clientId\": null\n" +
                    "}");
            tokenInfo.put("userInfo", jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        saveLoginLog(username, "用户名密码登陆");

        return new R(tokenInfo);
    }

    private static String httpbasic(String clientId, String clientSecret){
        //将客户端id和客户端密码拼接，按“客户端id:客户端密码”
        String string = clientId + ":" + clientSecret;
        //进行base64编码
        byte[] encode = Base64Utils.encode(string.getBytes());
        return "Basic " + new String(encode);
    }

    public static void main(String[] args) {
        String httpbasic = httpbasic(SystemClientInfo.CLIENT_ID, SystemClientInfo.CLIENT_SECRET);
        System.out.println(httpbasic);
    }

//    /**
//     * 短信登录
//     *
//     * @param phone
//     * @param key
//     * @param code
//     * @return
//     */
//    @PostMapping("/sys/login-sms")
//    public Map<String, Object> smsLogin(String phone, String key, String code) {
//        Map<String, String> parameters = new HashMap<>();
//        parameters.put(OAuth2Utils.GRANT_TYPE, "password");
//        parameters.put(OAuth2Utils.CLIENT_ID, SystemClientInfo.CLIENT_ID);
//        parameters.put("client_secret", SystemClientInfo.CLIENT_SECRET);
//        parameters.put(OAuth2Utils.SCOPE, SystemClientInfo.CLIENT_SCOPE);
//        // 为了支持多类型登录，这里在username后拼装上登录类型，同时为了校验短信验证码，我们也拼上code等
//        parameters.put("username", phone + "|" + CredentialType.PHONE.name() + "|" + key + "|" + code + "|"
//                + DigestUtils.md5Hex(key + code));
//        // 短信登录无需密码，但security底层有密码校验，我们这里将手机号作为密码，认证中心采用同样规则即可
//        parameters.put("password", phone);
//
//        Map<String, Object> tokenInfo = oauth2Client.postAccessToken(parameters);
//        saveLoginLog(phone, "手机号短信登陆");
//
//        return tokenInfo;
//    }
//
//    /**
//     * 微信登录
//     *
//     * @return
//     */
//    @PostMapping("/sys/login-wechat")
//    public Map<String, Object> smsLogin(String openid, String tempCode) {
//        Map<String, String> parameters = new HashMap<>();
//        parameters.put(OAuth2Utils.GRANT_TYPE, "password");
//        parameters.put(OAuth2Utils.CLIENT_ID, SystemClientInfo.CLIENT_ID);
//        parameters.put("client_secret", SystemClientInfo.CLIENT_SECRET);
//        parameters.put(OAuth2Utils.SCOPE, SystemClientInfo.CLIENT_SCOPE);
//        // 为了支持多类型登录，这里在username后拼装上登录类型，同时为了服务端校验，我们也拼上tempCode
//        parameters.put("username", openid + "|" + CredentialType.WECHAT_OPENID.name() + "|" + tempCode);
//        // 微信登录无需密码，但security底层有密码校验，我们这里将手机号作为密码，认证中心采用同样规则即可
//        parameters.put("password", tempCode);
//
//        Map<String, Object> tokenInfo = oauth2Client.postAccessToken(parameters);
//        saveLoginLog(openid, "微信登陆");
//
//        return tokenInfo;
//    }
//
//    @Autowired
//    private LogClient logClient;
//
//    /**
//     * 登陆日志
//     *
//     * @param username
//     */
//    private void saveLoginLog(String username, String remark) {
//        log.info("{}登陆", username);
//        // 异步
//        CompletableFuture.runAsync(() -> {
//            try {
//                Log log = Log.builder().username(username).module("登陆").remark(remark).createTime(new Date())
//                        .build();
//                logClient.save(log);
//            } catch (Exception e) {
//                // do nothing
//            }
//
//        });
//    }
//
//    /**
//     * 系统刷新refresh_token
//     *
//     * @param refresh_token
//     * @return
//     */
//    @PostMapping("/sys/refresh_token")
//    public Map<String, Object> refresh_token(String refresh_token) {
//        Map<String, String> parameters = new HashMap<>();
//        parameters.put(OAuth2Utils.GRANT_TYPE, "refresh_token");
//        parameters.put(OAuth2Utils.CLIENT_ID, SystemClientInfo.CLIENT_ID);
//        parameters.put("client_secret", SystemClientInfo.CLIENT_SECRET);
//        parameters.put(OAuth2Utils.SCOPE, SystemClientInfo.CLIENT_SCOPE);
//        parameters.put("refresh_token", refresh_token);
//
//        return oauth2Client.postAccessToken(parameters);
//    }
//
//    /**
//     * 退出
//     *
//     * @param access_token
//     */
//    @GetMapping("/sys/logout")
//    public void logout(String access_token, @RequestHeader(required = false, value = "Authorization") String token) {
//        if (StringUtils.isBlank(access_token)) {
//            if (StringUtils.isNoneBlank(token)) {
//                access_token = token.substring(OAuth2AccessToken.BEARER_TYPE.length() + 1);
//            }
//        }
//        oauth2Client.removeToken(access_token);
//    }
}
