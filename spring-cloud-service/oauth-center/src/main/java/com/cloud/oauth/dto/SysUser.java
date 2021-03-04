package com.cloud.oauth.dto;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * Title: SysUser
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2021-02-16
 */
@Data
public class SysUser implements Serializable {

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
	 * 密码;
	 */
	private String userPwd;

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
	 * 生成来源; 01:注册
	 */
	private String createFrom;

	/**
	 * 备注;
	 */
	private String userMark;

	/**
	 * 创建人;
	 */
	private String createBy;

	/**
	 * 创建时间;
	 */
	private Date createTime;

	/**
	 * 更新人;
	 */
	private String updateBy;

	/**
	 * 更新时间;
	 */
	private Date updateTime;

	private String idno;

}
