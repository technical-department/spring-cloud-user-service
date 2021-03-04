package com.cloud.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.user.config.TokenDecode;
import com.cloud.user.model.SysBaseInfo;
import com.cloud.user.service.SysBaseInfoService;
import com.cloud.user.vo.SysBaseInfoVo;
import com.common.response.R;
import com.common.util.BeanCloneUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * Title: SysBaseInfoController
 * </p>
 * <p>
 * Description:系统列表 业务处理
 * </p>
 * @author chenyouhong
 * @date 2021-02-16
 */
@Slf4j
@RestController
@RequestMapping("/baseinfo")
public class SysBaseInfoController {

	@Autowired
	private SysBaseInfoService sysBaseInfoService;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	@Autowired
	private TokenDecode tokenDecode;

	@GetMapping("/adminsys")
	@ApiOperation(value = "获取管理系统信息列表")
	public R adminSys() {
		List<SysBaseInfo> sysBaseInfos = sysBaseInfoService.findAdminSys();
		return new R(sysBaseInfos);
	}

	@GetMapping("/my/system")
	@ApiOperation(value = "获取当前用户信息列表")
	public R findMySystem() throws Exception {
		String userCode = tokenDecode.getUserInfo().getUserCode();
		List<SysBaseInfo> sysBaseInfos = sysBaseInfoService.findSysBaseInfoByUserCode(userCode);
		return new R(sysBaseInfos);
	}

	 @PostMapping("/page")
	 @ApiOperation(value = "分页")
//	 @PreAuthorize("hasAuthority('sys_system_list')")
	public R page(@RequestBody SysBaseInfoVo vo) {
		SysBaseInfo sysBaseInfo = dozerBeanMapper.map(vo, SysBaseInfo.class);
		Page<SysBaseInfo> page = sysBaseInfoService.page(new Page<>(vo.getCurrent(), vo.getSize()), new LambdaQueryWrapper<>(sysBaseInfo));
		return new R(page);
	}

	@PostMapping
	@ApiOperation(value = "编辑")
//	 @PreAuthorize("hasAuthority('sys_system_add')")
	public R edit(@RequestBody @Valid SysBaseInfoVo vo) throws Exception {
		SysBaseInfo sysBaseInfo = dozerBeanMapper.map(vo, SysBaseInfo.class);
		sysBaseInfoService.edit(sysBaseInfo);
		return new R();
	}

}