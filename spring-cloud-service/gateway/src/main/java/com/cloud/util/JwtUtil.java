package com.cloud.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

/**
 * 项目名称：spring-cloud-service
 * 类 名 称：JwtUtil
 * 类 描 述：TODO
 * 创建时间：2021/2/12 下午9:16
 * 创 建 人：chenyouhong
 */
public class JwtUtil {
    //有效期为
    public static final Long JWT_TTL = 3600000L;// 60 * 60 *1000  一个小时

    //Jwt令牌信息
    public static final String JWT_KEY = "itcast";

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
        try {
            Claims claims = JwtUtil.parseJWT("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhcHAiXSwibmFtZSI6bnVsbCwiaWQiOm51bGwsImV4cCI6MjA0NTEzNDcyOSwiYXV0aG9yaXRpZXMiOlsic2Vja2lsbF9saXN0IiwiZ29vZHNfbGlzdCJdLCJqdGkiOiJjZjM2MWI1MS1jYTIzLTQ2NDktOGUwYS1hZWY4Y2FmYjY1YjUiLCJjbGllbnRfaWQiOiJjaGFuZ2dvdSIsInVzZXJuYW1lIjoic3ppdGhlaW1hIn0.oxBr57GYFTQuvVBAyLTCwJ5v8OFgPymYGLUIqGuVMYB_Y2YbYzlFq6qO4h-C_LozBGkvHFkcMSTyYRKMYYnmzsOTB4gPulN27DmV-wtC79aLPE_MVA5wrfsacZK2vfa687P_3TuF1UsXX6nubhBS3knpagA9DkUjvRmN7WidIjuHkINktRZmRMHnXlSDufTZS7r75l5iG-sYWNEdRm4BkE1zEnxIjS23UbVh1I4dXnVpbOqJKnORg0rdelQw1ai4OovywmfBfKDzbrBgdxagHBmMitrHn_WIViIy7HwHNoh8d2W_oWkCKCbAOB2wobjp5_JZlzQ9ReEIJV13Rj6SLA");
            System.out.println(claims);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
