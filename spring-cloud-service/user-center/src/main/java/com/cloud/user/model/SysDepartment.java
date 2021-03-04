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
 * Title: SysDepartment
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2021-02-16
 */
@Data
@TableName("sys_department")
public class SysDepartment implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String companyCode;

	private String departName;

	private String departCode;

	private String parentDepartCode;

	private String managerCode;

	@TableField(fill = FieldFill.INSERT)
	private String createBy;

	@TableField(fill = FieldFill.INSERT)
	private Date createDate;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String updateBy;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateDate;

	@TableField(exist = false)
	private List<SysDepartment> children;

	@TableField(exist = false)
	private SysDepartment parent;
	
	@TableField(exist = false)
	private String managerName;
	
	@TableField(exist = false)
	private String parentName;

	
}
