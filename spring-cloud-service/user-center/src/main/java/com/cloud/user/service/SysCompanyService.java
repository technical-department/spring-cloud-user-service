package com.cloud.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.user.dto.CompanyAndDepartmentDTO;
import com.cloud.user.model.SysCompany;

import java.util.List;

/**
 * <p>Title: SysCompanyService</p>  
 * <p>Description: </p>  
 *
 * @author chenyouhong
 * @since 2021-02-16
 */
public interface SysCompanyService extends IService<SysCompany> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysCompany
	 */
	void deleteObj(SysCompany sysCompany);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysCompany
	 */
	void insertObj(SysCompany sysCompany);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysCompany
	 */
	void updateObj(SysCompany sysCompany);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysCompany
	 * @return
	 */
	List<SysCompany> findByObj(SysCompany sysCompany);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @return
	 */
	List<SysCompany> findAll();

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysCompany
	 * @return
	 */
	SysCompany findOneByObj(SysCompany sysCompany);
	
	List<CompanyAndDepartmentDTO> getAllCompanyAndDepartment();

}
