package com.cloud.oauth.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "lz-cloud-staticdata")
public interface StaticFeignClient {
	@GetMapping("/dic/merge/{typeCode}")
	public Map<String, String> merge(@PathVariable(name = "typeCode", required = true) String typeCode) ;
}
