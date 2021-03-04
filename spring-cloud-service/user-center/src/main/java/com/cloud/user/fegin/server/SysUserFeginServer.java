/**  

* <p>Title: UserController.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2018</p>  

* <p>Company: lianzhongjinrong</p>  

* @author sine  

* @date 2018年3月15日  

* @version 1.0  

*/
package com.cloud.user.fegin.server;

import com.alibaba.fastjson.JSON;
import com.cloud.user.fegin.client.dto.UserDTO;
import com.cloud.user.fegin.server.dto.*;
import com.cloud.user.model.SysBaseInfo;
import com.cloud.user.model.SysUser;
import com.cloud.user.service.SysBaseInfoService;
import com.cloud.user.service.SysUserService;
import com.common.exception.BusinessException;
import com.common.response.R;
import com.google.common.collect.Lists;
import com.jarvis.cache.annotation.Cache;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * <p>
 * Title: UserController
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * @author sine
 * 
 * @date 2018年3月15日
 * 
 */
@RestController
@Slf4j
@RequestMapping("/feign-service")
public class SysUserFeginServer {

	@Autowired
	private SysUserService sysUserService;

	@GetMapping("/sys/user/{userCode}")
	public R findByUserCode(@PathVariable(name = "userCode", required = false) String userCode) throws Exception {
		SysUser sysUser = sysUserService.findByUserCode(userCode);
		return new R(sysUser);
	}

}
