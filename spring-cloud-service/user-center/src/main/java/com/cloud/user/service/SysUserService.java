package com.cloud.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.user.model.SysRole;
import com.cloud.user.model.SysUser;
import com.cloud.user.vo.SysUserSetRoleVo;
import com.cloud.user.vo.SysUserVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Title: SysUserService
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author chenyouhong
 * @since 2021-02-16
 */
public interface SysUserService extends IService<SysUser> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param userCode
	 * @return
	 */
	SysUser findByUserCode(String userCode);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param vo
	 * @return
	 */
	Page<SysUser> selectSysUserPage(SysUserVo vo);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param userCode
	 * @return
	 */
	List<SysRole> getRoleLst(String userCode);

	void editRole(SysUserSetRoleVo vo) throws Exception;

}
