package com.cloud.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.user.dto.RoleResourceTree;
import com.cloud.user.model.SysResource;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Title: SysResourceService
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author chenyouhong
 * @since 2021-02-16
 */
public interface SysResourceService extends IService<SysResource> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param systemCode
	 * @return
	 */
	List<SysResource> findTreeLst(String systemCode) throws Exception;

	RoleResourceTree findResourceBySystemCodeAndRoleCode(String systemCode, String roleCode) throws Exception;

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param userCode
	 * @param systemCode
	 * @return
	 */
	List<SysResource> findSysResourceBySystemCodeAndUserCode(String userCode, String systemCode) throws Exception;

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysResource
	 * @return
	 */
	void edit(SysResource sysResource) throws Exception;

}
