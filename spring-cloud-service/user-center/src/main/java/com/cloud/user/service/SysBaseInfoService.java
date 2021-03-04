package com.cloud.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.user.model.SysBaseInfo;
import com.common.exception.BusinessException;

import java.util.List;

/**
 * <p>Title: SysBaseInfoService</p>  
 * <p>Description: </p>  
 *
 * @author carter
 * @since 2021-02-10
 */
public interface SysBaseInfoService extends IService<SysBaseInfo> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysBaseInfo
	 */
//	void deleteObj(SysBaseInfo sysBaseInfo);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysBaseInfo
	 */
	void edit(SysBaseInfo sysBaseInfo) throws BusinessException;


//	/**
//	 * <p>
//	 * Description:
//	 * </p>
//	 * @param sysBaseInfo
//	 */
//	void updateObj(SysBaseInfo sysBaseInfo) throws BusinessException;
//
//	/**
//	 * <p>
//	 * Description:
//	 * </p>
//	 * @param sysBaseInfo
//	 * @return
//	 */
//	List<SysBaseInfo> findByObj(SysBaseInfo sysBaseInfo);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysBaseInfo
	 * @return
	 */
	SysBaseInfo findOneByObj(SysBaseInfo sysBaseInfo);

	/**
	 * <p>Description: </p>
	 * @param systemCode
	 * @return
	 */
	SysBaseInfo findSystemCode(String systemCode);

	/**
	 * <p>Description: 获取管理系统信息列表</p>
	 * @return
	 */
	List<SysBaseInfo> findAdminSys();

	/**
	 * <p>Description: </p>
	 * @param userCode
	 * @return
	 */
	List<SysBaseInfo> findSysBaseInfoByUserCode(String userCode);

	/**
	 * <p>Description: </p>
	 * @return
	 */
	List<SysBaseInfo> findAllSys();

}
