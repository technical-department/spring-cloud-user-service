package com.cloud.oauth.feign.client;

import com.common.response.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(name = "user-center")
@RequestMapping("/feign-service")
public interface SysUserFeignClient {

	@GetMapping("/sys/user/{userCode}")
	R findByUserCode(@RequestHeader Map<String, Object> header, @PathVariable(name = "userCode", required = false) String userCode) throws Exception;

}
