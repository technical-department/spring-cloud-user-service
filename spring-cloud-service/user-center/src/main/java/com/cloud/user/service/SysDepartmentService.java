package com.cloud.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.user.model.SysDepartment;

import java.util.List;

/**
 * <p>Title: SysDepartmentService</p>  
 * <p>Description: </p>  
 *
 * @author chenyouhong
 * @since 2021-02-16
 */
public interface SysDepartmentService extends IService<SysDepartment> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysDepartment
	 */
	void deleteObj(SysDepartment sysDepartment);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysDepartment
	 */
	void insertObj(SysDepartment sysDepartment);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysDepartment
	 */
	void updateObj(SysDepartment sysDepartment);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysDepartment
	 * @return
	 */
	List<SysDepartment> findByObj(SysDepartment sysDepartment);
	
	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysDepartment
	 * @return
	 */
	SysDepartment findOneByObj(SysDepartment sysDepartment);

	/**  
	 * <p>Description: </p>  
	 * @param companyCode
	 * @return  
	 */
	List<SysDepartment> findRootLst(String companyCode);

	/**  
	 * <p>Description: </p>  
	 * @param code
	 * @return  
	 */
	List<SysDepartment> findChildLst(String code);

	List<SysDepartment> findSysDepartmentByCompanyCode(String companyCode) throws Exception;

	List<SysDepartment> findTreeLst(SysDepartment param);
	
	List<SysDepartment> findAllChildLst(String code);
	
	SysDepartment findChildTreeLst(SysDepartment root);


	

}
