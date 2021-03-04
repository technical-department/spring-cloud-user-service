package com.cloud.user.controller;

import com.cloud.user.dto.CompanyAndDepartmentDTO;
import com.cloud.user.dto.SysCompanyDTO;
import com.cloud.user.model.SysCompany;
import com.cloud.user.model.SysDepartmentPosition;
import com.cloud.user.service.SysCompanyService;
import com.common.response.R;
import com.common.util.BeanCloneUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration.tree.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Title: SysCompanyController
 * </p>
 * <p>
 * Description:公司 业务处理
 * </p>
 * @author chenyouhong
 * @date 2021-02-16
 */
@RestController
@RequestMapping("/company")
@Slf4j
public class SysCompanyController {

	@Autowired
	private SysCompanyService sysCompanyService;
	
//	@Autowired
//	private SysDepartmentPositionService sysDepartmentPositionService;
//
	
	@GetMapping("/all")
	@ApiOperation(value = "获取所有列表")
	public R listAll() {
		List<SysCompany> sysCompanies = sysCompanyService.findAll();
		List<SysCompanyDTO> companies = BeanCloneUtils.copyTo(sysCompanies, SysCompanyDTO.class);
		return new R(companies);
	}

}