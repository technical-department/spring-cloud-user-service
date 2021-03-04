package com.cloud.user.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cloud.user.dto.SystemBaseInfo;
import com.cloud.user.model.SysBaseInfo;
import com.cloud.user.model.SysRole;
import com.cloud.user.model.SysRoleResources;
import com.cloud.user.service.SysBaseInfoService;
import com.cloud.user.service.SysRoleService;
import com.cloud.user.vo.SysRoleVo;
import com.common.response.R;
import com.common.util.BeanCloneUtils;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * Title: SysRoleController
 * </p>
 * <p>
 * Description:系统角色 业务处理
 * </p>
 * @author chenyouhong
 * @date 2018-05-17
 */
@Slf4j
@RestController
@RequestMapping("/sysrole")
public class SysRoleController {

	@Autowired
	private SysRoleService sysRoleService;

//	@Autowired
//	private SysRoleResourcesService sysRoleResourcesService;

	@Autowired
	private SysBaseInfoService sysBaseInfoService;

	@Autowired
	private static Mapper mapper;


	@GetMapping("/transferList")
	@ApiOperation(value = "获取所有列表")
	public R list() {
		List<SysRole> sysRoles = sysRoleService.findAllAvailable();
		return new R(sysRoles);
	}

	@PostMapping
//	@PreAuthorize("hasAuthority('sys_role_add_my')")
	@ApiOperation(value = "添加角色")
	public R add(@RequestBody @Valid SysRoleVo vo) throws Exception {
		sysRoleService.add(vo);
		return new R();
	}

	@GetMapping("/role/tree")
	@ApiOperation(value = "获取所有的角色")
	public R getAllRolesTree() throws Exception {
		List<SysBaseInfo> root = sysRoleService.getAllRolesTree();
		List<SystemBaseInfo> systemBaseInfos = BeanCloneUtils.copyTo(root, SystemBaseInfo.class);
		return new R(systemBaseInfos);
	}

}