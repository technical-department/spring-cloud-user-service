package com.cloud.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.user.model.SysBaseInfo;
import com.cloud.user.model.SysRole;
import com.cloud.user.vo.SysRoleVo;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Title: SysRoleService
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author chenyouhong
 * @since 2021-02-16
 */
public interface SysRoleService extends IService<SysRole> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysRole
	 * @throws Exception
	 */
	void deleteObj(SysRole sysRole) throws Exception;

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysRole
	 */
	void insertObj(SysRole sysRole);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysRole
	 */
	void updateObj(SysRole sysRole);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysRole
	 * @return
	 */
	List<SysRole> findByObj(SysRole sysRole);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysRole
	 * @return
	 */
	SysRole findOneByObj(SysRole sysRole);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param page
	 * @param params
	 * @return
	 */
	Page selectMyPage(Page page, Map<String, Object> params);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param userCode
	 * @return
	 */
	List<SysRole> findLstByUserCode(String userCode);

	/**  
	 * <p>Description: </p>  
	 * @return  
	 */
	List<SysRole> findAllAvailable();
	
	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param userId
	 * @return
	 */
	List<SysRole> findLstByPositionId(Long positionId);

	List<SysRole> findLstByPositionIds(List<Long> positionIds);

	void addMy(SysRole add) throws Exception;

	void add(SysRoleVo vo) throws Exception;

	List<SysBaseInfo> getAllRolesTree() throws Exception;

	SysRole selectAllResourceByRoleCode(String roleCode) throws Exception;

	SysRole findSysRoleByRoleCode(String roleCode) throws Exception;

}
