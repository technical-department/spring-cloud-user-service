package com.cloud.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.user.model.SysDepartment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* <p>
* Title: SysDepartmentDao
* </p>
* <p>
* Description:
* </p>
* @author chenyouhong
* @since 2021-02-16
*/
public interface SysDepartmentMapper extends BaseMapper<SysDepartment> {

   List<SysDepartment> findSysDepartmentByCompanyCode(@Param("companyCode") String companyCode);

}
