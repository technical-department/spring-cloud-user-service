package com.cloud.user.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * Title: SysRole
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2021-02-16
 */
@Data
@TableName("sys_role")
public class SysRole implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id;
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 角色code;
	 */
	private String roleCode;

	/**
	 * 所属系统;
	 */
	private String systemCode;

	/**
	 * 角色名称;
	 */
	private String roleName;

	/**
	 * 描述;
	 */
	private String roleRemark;

	/**
	 * 状态;
	 */
	private Integer status;

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

	@TableField(exist = false)
	private String systemName;

	@TableField(exist = false)
	private List<Long> resourcesIds;

}
