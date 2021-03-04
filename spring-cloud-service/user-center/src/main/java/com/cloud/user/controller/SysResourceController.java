/**  

* <p>Title: SysResourceController.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2018</p>  

* <p>Company: lianzhongjinrong</p>  

* @author sine  

* @date 2018年3月26日  

* @version 1.0  

*/
package com.cloud.user.controller;

import com.cloud.user.config.TokenDecode;
import com.cloud.user.dto.RoleResourceTree;
import com.cloud.user.model.SysResource;
import com.cloud.user.model.SysRole;
import com.cloud.user.service.SysResourceService;
import com.cloud.user.vo.SysResourceVo;
import com.common.constants.Constants;
import com.common.response.R;
import com.common.util.BeanCloneUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mergeplus.core.MergeCore;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 
 * <p>
 * Title: SysResourceController
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * @author sine
 * 
 * @date 2018年3月26日
 * 
 */
@Slf4j
@RestController
@RequestMapping("sysrescource")
public class SysResourceController {

	@Autowired
	private TokenDecode tokenDecode;

	@Autowired
	private SysResourceService sysResourceService;

	@GetMapping("/menu/{systemCode}")
	@ApiOperation("通过系统编码查询资源")
	public R getMenu(@PathVariable(name = "systemCode", required = true) String systemCode) throws Exception {
		String userCode = tokenDecode.getUserInfo().getUserCode();
		List<SysResource> sysResources = sysResourceService.findSysResourceBySystemCodeAndUserCode(systemCode, userCode);
		return new R(sysResources);
	}

	@GetMapping("/tree/{systemCode}")
	@ApiOperation(value = "获取树结构")
	public R tree(@PathVariable(name = "systemCode", required = true) String systemCode) throws Exception {
		List<SysResource> lst = sysResourceService.findTreeLst(systemCode);
		return new R(lst);
	}

	@GetMapping("/{systemCode}/{roleCode}")
	@ApiOperation(value = "获取列表")
	public R findResource(@PathVariable(name = "systemCode", required = true) String systemCode,
						   @PathVariable(name = "roleCode", required = true) String roleCode) throws Exception {
		RoleResourceTree roleResourceTree = sysResourceService.findResourceBySystemCodeAndRoleCode(systemCode, roleCode);
		return new R(roleResourceTree);
	}

	@PostMapping
	@ApiOperation(value = "编辑")
//	@PreAuthorize("hasAuthority('sys_resource_add')")
	public R edit(@RequestBody @Valid SysResourceVo vo) throws Exception {
		SysResource sysResource = BeanCloneUtils.copyTo(vo, SysResource.class);
		sysResourceService.edit(sysResource);
		return new R();
	}

}
