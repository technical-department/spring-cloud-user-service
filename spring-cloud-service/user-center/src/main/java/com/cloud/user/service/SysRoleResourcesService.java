package com.cloud.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.user.model.SysRoleResources;
import com.cloud.user.vo.SysRoleResourceVo;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: SysRoleResourcesService</p>  
 * <p>Description: </p>  
 *
 * @author chenyouhong
 * @since 2018-05-21
 */
public interface SysRoleResourcesService extends IService<SysRoleResources> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysRoleResources
	 */
	void deleteObj(SysRoleResources sysRoleResources);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysRoleResources
	 */
	void insertObj(SysRoleResources sysRoleResources);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysRoleResources
	 */
	void updateObj(SysRoleResources sysRoleResources);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysRoleResources
	 * @return
	 */
	List<SysRoleResources> findByObj(SysRoleResources sysRoleResources);
	
	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param sysRoleResources
	 * @return
	 */
	SysRoleResources findOneByObj(SysRoleResources sysRoleResources);
	
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
	 * <p>Description: </p>  
	 * @param vo
	 */
	void editResource(SysRoleResourceVo vo) throws Exception;

	List<SysRoleResources> findSysRoleResourceByRoleCode(String roleCode) throws Exception;

}
