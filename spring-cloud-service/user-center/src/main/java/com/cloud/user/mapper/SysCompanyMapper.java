package com.cloud.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.user.dto.CompanyAndDepartmentDTO;
import com.cloud.user.model.SysCompany;

import java.util.List;

/**
* <p>
* Title: SysCompanyDao
* </p>
* <p>
* Description:
* </p>
* @author chenyouhong
* @since 2021-02-16
*/
public interface SysCompanyMapper extends BaseMapper<SysCompany> {

   List<CompanyAndDepartmentDTO> getAllCompanyAndDepartment();

}
