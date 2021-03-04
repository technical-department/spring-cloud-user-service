package com.cloud.feign;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient("user-auth")
public interface Oauth2Client {

    /**
     * 获取access_token<br>
     * 这是spring-security-oauth2底层的接口，类TokenEndpoint<br>
     * 感兴趣可看下视频章节05.5 生成access_token的核心源码
     *
     * @param parameters
     * @return
     * @see org.springframework.security.oauth2.provider.endpoint.TokenEndpoint
     */
////    @PostMapping(path = "/oauth/token")
////    @RequestMapping(method = RequestMethod.POST, value = "/oauth/token", headers = {"Content-Type: multipart/form-data", "Authorization=Basic c3lzdGVtOnN5c3RlbQ==","Tenant-Id=000000"})
//    @RequestMapping(method = RequestMethod.POST, value = "/oauth/token", headers = { "Authorization=Basic Y2hhbmdnb3U6Y2hhbmdnb3U="})
////    @RequestMapping(method = RequestMethod.POST, value = "/oauth/token", headers = {"Content-Type: application/x-www-form-urlencoded", "Authorization=Basic Y2hhbmdnb3U6Y2hhbmdnb3U="})
//    Map<String, Object> postAccessToken(@RequestParam Map parameters);



    @PostMapping(value = "/oauth/token")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    Map<String, Object> postAccessToken(@RequestHeader Map<String, Object> header, @RequestParam Map parameters);

    /**
     * 删除access_token和refresh_token<br>
     * 认证中心的OAuth2Controller方法removeToken
     *
     * @param access_token
     */
    @DeleteMapping(path = "/user-auth/remove_token")
    void removeToken(@RequestParam("access_token") String access_token);

}
