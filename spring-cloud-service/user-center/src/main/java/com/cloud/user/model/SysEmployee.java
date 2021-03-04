package com.cloud.user.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * Title: SysEmployee
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2021-02-16
 */
@Data
@TableName("sys_employee")
public class SysEmployee implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String employeeName;

	private String userCode;

	private String idno;

	private String positionId;
	@TableField(exist = false)
	private List<Long> positionIds;

	private String address;

	private String userMobile;

	private String tel;

	private String otherMobile;

	private String userEmail;
	
	/**
	 * 是否在职 1 在职 0 离职
	 */
	private String isWork;
	/**
	 * 入职日期
	 */
	private Date inductionDate;
	/**
	 * 离职日期
	 */
	private Date dimissionDate;
	/**
	 * 曾用员工编号
	 */
	private String formerUserCode;
	
	private String parentUserCode;

	@TableField(fill = FieldFill.INSERT)
	private String createBy;

	@TableField(fill = FieldFill.INSERT)
	private Date createDate;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String updateBy;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateDate;
	@TableField(exist = false)
	private String locked;
	
	@TableField(exist = false)
	private List<SysEmployee> childs;

	/**
	 * 所属部门
	 */
	@TableField(exist = false)
	private String departName;

	@TableField(exist = false)
	private String departCode;

	@TableField(exist = false)
	private String parentDepartCode;

}
