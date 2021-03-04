package com.cloud.user.fegin.server.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * Title: SysUserVO
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2018-05-16
 */
@Data
public class SysUserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id;
	 */
	private Long id;

	/**
	 * 所属系统
	 */
	private String systemCode;

	/**
	 * 用户编码;
	 */
	private String userCode;

	/**
	 * 账户;
	 */
	private String userAccount;

	/**
	 * 用户名;
	 */
	private String userName;

	/**
	 * 用户性别; 1-男，0-女
	 */
	private String userSex;

	/**
	 * 手机号码;
	 */
	private String userMobile;

	/**
	 * 电子邮件;
	 */
	private String userEmail;

	/**
	 * 是否锁定;
	 */
	private Integer locked;

	/**
	 * 用户状态;
	 */
	private Integer userStatus;

	/**
	 * 上次登录时间;
	 */
	private Date lastLoginDate;

	/**
	 * 备注;
	 */
	private String userMark;

	/**
	 * 证件
	 */
	private String idno;

	@JSONField(format = "yyyy-MM-dd")
	private Date inductionDate;
	@JSONField(format = "yyyy-MM-dd")
	private Date dimissionDate;

	private String formerUserCode;

	private String managerCode;

	private String managerName;

}
