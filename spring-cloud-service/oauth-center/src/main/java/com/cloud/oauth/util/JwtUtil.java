package com.cloud.oauth.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * 描述
 *
 * @author carter
 * @version 1.0
 * @package entity *
 * @since 1.0
 */
public class JwtUtil {
    //有效期为
    public static final Long JWT_TTL = 3600000L;// 60 * 60 *1000  一个小时

    //Jwt令牌信息
    public static final String JWT_KEY = "microservice";

    private static final String PUBLIC_KEY = "public.key";


    /**
     * 生成令牌
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String id, String subject, Long ttlMillis) {
        //指定算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        //当前系统时间
        long nowMillis = System.currentTimeMillis();
        //令牌签发时间
        Date now = new Date(nowMillis);

        //如果令牌有效期为null，则默认设置有效期1小时
        if (ttlMillis == null) {
            ttlMillis = JwtUtil.JWT_TTL;
        }

        //令牌过期时间设置
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);

        //生成秘钥
        SecretKey secretKey = generalKey();

        //封装Jwt令牌信息
        JwtBuilder builder = Jwts.builder()
                .setId(id)                    //唯一的ID
                .setSubject(subject)          // 主题  可以是JSON数据
                .setIssuer("admin")          // 签发者
                .setIssuedAt(now)             // 签发时间
                .signWith(signatureAlgorithm, secretKey) // 签名算法以及密匙
                .setExpiration(expDate);      // 设置过期时间
        return builder.compact();
    }

    /**
     * 生成令牌
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String id, String subject, String issuer, Long ttlMillis) {
        //指定算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        //当前系统时间
        long nowMillis = System.currentTimeMillis();
        //令牌签发时间
        Date now = new Date(nowMillis);

        //如果令牌有效期为null，则默认设置有效期1小时
        if (ttlMillis == null) {
            ttlMillis = JwtUtil.JWT_TTL;
        }

        //令牌过期时间设置
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);

        //生成秘钥
        SecretKey secretKey = generalKey();

        //封装Jwt令牌信息
        JwtBuilder builder = Jwts.builder()
                .setId(id)                    //唯一的ID
                .setSubject(subject)          // 主题  可以是JSON数据
                .setIssuer(issuer)          // 签发者
                .setIssuedAt(now)             // 签发时间
                .signWith(signatureAlgorithm, secretKey) // 签名算法以及密匙
                .setExpiration(expDate);      // 设置过期时间
        return builder.compact();
    }

    /**
     * 生成加密 secretKey
     *
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getEncoder().encode(JwtUtil.JWT_KEY.getBytes());
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }


    /**
     * 解析令牌数据
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

    public static void main(String[] args) {
//        String jwt = JwtUtil.createJWT("weiyibiaoshi", "aaaaaa", null);
//        System.out.println(jwt);
//        try {
//            Claims claims = JwtUtil.parseJWT("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjIwNDU0NzExNjQsInVzZXJfbmFtZSI6InN6aXRoZWltYSIsImF1dGhvcml0aWVzIjpbInNlY2tpbGxfbGlzdCIsImdvb2RzX2xpc3QiXSwianRpIjoiYmU1NTUxZTYtMGIwMS00MzEyLTgwMzktOWJjYmM1ZjA4ZWFmIiwiY2xpZW50X2lkIjoiY2hhbmdnb3UiLCJzY29wZSI6WyJhcHAiXX0.BP_KG3nMOBozznIFDVMCzgLDj4jSI15wzHMBO0PV5LE");
//            System.out.println(claims);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //{"ext":"1","name":"mrt","id":"123"}

        String pubKey = getPubKey();

        Jwt jwt2 = JwtHelper.decodeAndVerify("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhcHAiXSwibmFtZSI6bnVsbCwiaWQiOm51bGwsImV4cCI6MjA0NTU0NzkwNSwianRpIjoiNjY3MTE3MTktNDBiNy00MzU5LWJmNGItMGJjZDE4MmEwMDg1IiwiY2xpZW50X2lkIjoiY2hhbmdnb3UiLCJ1c2VybmFtZSI6InN6aXRoZWltYSJ9.ioFb21vw0VNONHclZs5uI_SfIIpolCxxrLLlu8LwGuv-hu39B-njWvncYuOzM-u612ICtkdC6hiw7214tWzROBSJr2acbRerMXsztmjLCiKsCMRFcXsmqyTOaUf76RJ8IxQpVufQTB-qMQ-8FIE2N9LAr9Tw2dx_hKWZcGj-PbRJ5dWqQVmfvPdubOeroQ2_3LyUs0MQ6hMuVnVDwIA8va22vwsOBtfBdsOltlVKXKXg7W9ner5RHpxVOY_JCwuRs3StkB0XB_lh_jo6B3MyMluAAGrSuBIDxlu4PMfuGlzdNCMwhJ6T6QOvgt02v41Ombj5Q9ZEPF74iI20G2TFVg",
        new RsaVerifier(pubKey));
        System.out.println("******======");

        System.out.println(jwt2);


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


}
