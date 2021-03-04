package com.cloud.user.model;

import com.baomidou.mybatisplus.annotation.*;
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
@TableName("sys_user")
public class SysUser implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id;
	 */
	@TableId(value = "id", type = IdType.AUTO)
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
	@TableField(fill = FieldFill.INSERT)
	private String createBy;

	/**
	 * 创建时间;
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

	/**
	 * 更新人;
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String updateBy;

	/**
	 * 更新时间;
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

	private String idno;

	@TableField(exist = false)
	private String rcode;

	/**
	 * 所属公司
	 */
	@TableField(exist = false)
	private String companyName;
	@TableField(exist = false)
	private String companyCode;
	/**
	 * 所属部门
	 */
	@TableField(exist = false)
	private String departName;
	@TableField(exist = false)
	private String departCode;
	/**
	 * 所属岗位
	 */
	@TableField(exist = false)
	private String positionName;
	@TableField(exist = false)
	private String positionIdTemp;
	@TableField(exist = false)
	private List<Long> positionIds;
	@TableField(exist = false)
	private List<Long> roleIds;
	@TableField(exist = false)
	private String roleName;
	@TableField(exist = false)
	private String isWork;
	@TableField(exist = false)
	private Date inductionDate;
	@TableField(exist = false)
	private Date dimissionDate;
	@TableField(exist = false)
	private String formerUserCode;
	@TableField(exist = false)
	private String parentUserCode;

	@TableField(exist = false)
	private String threeElementValid;

	@TableField(exist = false)
	private String employeeIdNo;

	@TableField(exist = false)
	private String openId;

	/**
	 * 1 为外部人员
	 */
	@TableField(exist = false)
	private String external;

	@TableField(exist = false)
	private List<SysDepartment> sysDepartments;

	@TableField(exist = false)
	private List<SysDepartmentPosition> sysDepartmentPositions;

	/**
	 * 如果是员工，则取员工身份证
	 * @return
	 */
	public String getIdno() {
		if (StringUtils.isNotBlank(this.employeeIdNo)) {
			return this.employeeIdNo;
		}
		else {
			return this.idno;
		}
	}

}
