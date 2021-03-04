package com.cloud.oauth.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.tomcat.jni.File;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.stereotype.Component;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 描述
 *
 * @author carter
 * @version 1.0
 * @package com.changgou.order.config *
 * @since 1.0
 */

@Component
public class TokenDecode {

    private static final String PUBLIC_KEY = "public.key";
    private static final String PRIVATE_KEY = "microservice.jks";

    // 获取令牌
    public String getToken() {
        OAuth2AuthenticationDetails authentication = (OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();

        String tokenValue = authentication.getTokenValue();//

        return tokenValue;
    }


    /**
     * 获取当前的登录的用户的用户信息
     *
     * @return
     */
    public Map<String, String> getUserInfo() {
        //1.获取令牌
        String token = getToken();

        //2.解析令牌  公钥
        String pubKey = getPubKey();

        Jwt jwt = JwtHelper.decodeAndVerify(token, new RsaVerifier(pubKey));
        String claims = jwt.getClaims();//{}

        //3.返回
        Map<String,String> map = JSON.parseObject(claims, Map.class);
        return map;
    }

    private static String getPubKey() {
        Resource resource = new ClassPathResource(PUBLIC_KEY);
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(resource.getInputStream());
            BufferedReader br = new BufferedReader(inputStreamReader);
            return br.lines().collect(Collectors.joining("\n"));
        } catch (IOException ioe) {
            return null;
        }
    }

    private static String getPriKey2() {
        Resource resource = new ClassPathResource(PRIVATE_KEY);
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(resource.getInputStream());
            BufferedReader br = new BufferedReader(inputStreamReader);
            return br.lines().collect(Collectors.joining("\n"));
        } catch (IOException ioe) {
            return null;
        }
    }


    private static String getPriKey() {
        Resource resource = new ClassPathResource(getPriKey2());
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(resource.getInputStream());
            BufferedReader br = new BufferedReader(inputStreamReader);
            return br.lines().collect(Collectors.joining("\n"));
        } catch (IOException ioe) {
            return null;
        }
    }

    public static void main(String[] args) {
        //定义payload信息
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("id", "123");
        tokenMap.put("name", "mrt");
        tokenMap.put("ext", "1");

//        location: classpath:/microservice.jks
//        secret: microservice
//        alias: microservice
//        password: microservice
        Resource resource = new ClassPathResource("/Users/chenyouhong/Desktop/study/spring-cloud-service/oauth-center/src/main/resources/microservice.jks");

        KeyPair keyPair = new KeyStoreKeyFactory(
                resource,
                "microservice".toCharArray())
                .getKeyPair(
                        "microservice",
                        "microservice".toCharArray());

//        Jwt jwt = JwtHelper.encode(JSON.toJSONString(tokenMap), new RsaSigner((RSAPrivateKey)keyPair.getPrivate()));
//        String claims = jwt.getClaims();
//        System.out.println(claims);
//        String token = jwt.;



//        System.out.println(token);

//        RsaVerifier rsaVerifier = new RsaVerifier(getPubKey());
//        Jwt jwt = JwtHelper.decodeAndVerify("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhcHAiXSwibmFtZSI6bnVsbCwiaWQiOm51bGwsImV4cCI6MjA0NTEzNDcyOSwiYXV0aG9yaXRpZXMiOlsic2Vja2lsbF9saXN0IiwiZ29vZHNfbGlzdCJdLCJqdGkiOiJjZjM2MWI1MS1jYTIzLTQ2NDktOGUwYS1hZWY4Y2FmYjY1YjUiLCJjbGllbnRfaWQiOiJjaGFuZ2dvdSIsInVzZXJuYW1lIjoic3ppdGhlaW1hIn0.oxBr57GYFTQuvVBAyLTCwJ5v8OFgPymYGLUIqGuVMYB_Y2YbYzlFq6qO4h-C_LozBGkvHFkcMSTyYRKMYYnmzsOTB4gPulN27DmV-wtC79aLPE_MVA5wrfsacZK2vfa687P_3TuF1UsXX6nubhBS3knpagA9DkUjvRmN7WidIjuHkINktRZmRMHnXlSDufTZS7r75l5iG-sYWNEdRm4BkE1zEnxIjS23UbVh1I4dXnVpbOqJKnORg0rdelQw1ai4OovywmfBfKDzbrBgdxagHBmMitrHn_WIViIy7HwHNoh8d2W_oWkCKCbAOB2wobjp5_JZlzQ9ReEIJV13Rj6SLA",
//                rsaVerifier);
//
//        System.out.println(jwt);

    }



}
