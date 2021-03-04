package com.cloud.user.controller;

import com.cloud.user.model.SysRoleResources;
import com.cloud.user.service.SysRoleResourcesService;
import com.cloud.user.vo.SysRoleResourceVo;
import com.common.response.R;
import com.common.util.BeanCloneUtils;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * Title: SysRoleResourcesController
 * </p>
 * <p>
 * Description:角色资源 业务处理
 * </p>
 * @author chenyouhong
 * @date 2018-05-21
 */
@Slf4j
@RestController
@RequestMapping("/sysRoleResources")
public class SysRoleResourcesController {

	@Autowired
	private SysRoleResourcesService sysRoleResourcesService;

	@PostMapping
	@ApiOperation(value = "编辑资源")
	public R editResource(@RequestBody @Valid SysRoleResourceVo vo) throws Exception {
		sysRoleResourcesService.editResource(vo);
		return new R();
	}


}