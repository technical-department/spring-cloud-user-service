package com.cloud.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.user.model.SysUserRoles;
import com.cloud.user.vo.SysUserSetRoleVo;

import java.util.List;

/**
 * <p>Title: SysUserRolesService</p>  
 * <p>Description: </p>  
 *
 * @author chenyouhong
 * @since 2021-02-16
 */
public interface SysUserRolesService extends IService<SysUserRoles> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysUserRoles
	 */
	void deleteObj(SysUserRoles sysUserRoles);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysUserRoles
	 */
	void insertObj(SysUserRoles sysUserRoles);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysUserRoles
	 */
	void updateObj(SysUserRoles sysUserRoles);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysUserRoles
	 * @return
	 */
	List<SysUserRoles> findByObj(SysUserRoles sysUserRoles);
	
	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysUserRoles
	 * @return
	 */
	SysUserRoles findOneByObj(SysUserRoles sysUserRoles);

	/**  
	 * <p>Description: </p>  
	 * @param userId
	 * @param roleIds  
	 */
	void insertBatch(Long userId, List<Long> roleIds);

	void editRole(SysUserSetRoleVo vo) throws Exception;
	
	/**  
	 * <p>Description: </p>  
	 * @param userId
	 * @param roleIds  
	 */
	void insertPositionBatch(Long userId, List<Long> roleIds);

	void deleteByUserIdAndRoleId(List<Long> userIds, List<Long> dbRoleIds);

}
