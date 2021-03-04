package com.cloud.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.user.model.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Title: SysUserDao
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2021-02-16
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param userAccount
	 * @param systemType
	 * @return
	 */
	List<SysUser> findOneByUserAccount(@Param("userAccount") String userAccount,
                                       @Param("systemType") String systemType);

	List<SysUser> findOneByUserAccountInsSystemCode(@Param("userAccount") String userAccount,
                                                    @Param("systemType") String systemType, @Param("systemCode") String systemCode);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param page
	 * @param params
	 * @return
	 */
	List<SysUser> selectSysUserPage(Page page, @Param(value = "p") Map<String, Object> params);

	List<SysUser> getUserLstByPositionId(Long positionId);

	/**
	 * 根据部门编码，查询所有的用户
	 * @param departs
	 * @return
	 */
	List<SysUser> getUserLstByDeparts(@Param("list") List<String> departs);

	List<SysUser> findOneByUserMobile(@Param("userMobile") String userMobile, @Param("systemType") String systemType);

	List<SysUser> selectSendSMS();

	List<SysUser> findOneByUserCodeAdmin(@Param("userCode") String userCode, @Param("systemType") String systemType);

	List<SysUser> findOneByUserMobileAdmin(@Param("userMobile") String userMobile,
                                           @Param("systemType") String systemType);

	List<SysUser> selectUserPage(RowBounds page, Map<String, Object> params);

	List<SysUser> findValidByIdNo(@Param("idNo") String idNo, @Param("systemType") String systemType);

	SysUser findValidUser(@Param("userAccount") String userAccount, @Param("userName") String userName);
	
	SysUser findValidUserByIdnoAndNameAndGh(@Param("userAccount") String userAccount, @Param("userName") String userName, @Param("idno") String idno);

	SysUser findValidUserAccount(@Param("userAccount") String userAccount);

	SysUser findValidSPUserAccount(@Param("userAccount") String userAccount);

	List<SysUser> findOneByIdnoInsSystemCode(@Param("idno") String idno, @Param("systemType") String systemType,
                                             @Param("systemCode") String systemCode);

	List<String> findUserCodesByAuthCode(@Param("authCode") String authCode);

	List<String> findUserAuthorities(@Param("userCode") String userCode);

	List<String> findUserLstByAuth(@Param("permission") String permission);

	/**
	 * 根据部门编码，查询所有的有效用户
	 * @param departs
	 * @return
	 */
	List<SysUser> findUserByDepartCode(@Param("list") List<String> departs);

}
