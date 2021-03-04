package com.cloud.user.controller;

import com.cloud.user.model.SysDepartment;
import com.cloud.user.service.SysDepartmentService;
import com.cloud.user.service.SysUserService;
import com.common.response.R;
import com.common.util.BeanCloneUtils;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * Title: SysDepartmentController
 * </p>
 * <p>
 * Description:部门 业务处理
 * </p>
 * @author chenyouhong
 * @date 2021-02-16
 */
@Slf4j
@RestController
@RequestMapping("/department")
public class SysDepartmentController {

	@Autowired
	private SysDepartmentService sysDepartmentService;
	
	@Autowired
	private SysUserService sysUserService;

	@GetMapping("/tree/{companyCode}")
	@ApiOperation(value = "获取列表")
	public R findSysDepartmentTree(@PathVariable(name = "companyCode", required = true) String companyCode) throws Exception {
		List<SysDepartment> sysDepartments = sysDepartmentService.findSysDepartmentByCompanyCode(companyCode);
		return new R(sysDepartments);
	}


}