package com.cloud.user.model;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * Title: SysResource
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2021-02-16
 */
@Data
@TableName("sys_resource")
public class SysResource implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id;
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 资源 Code;
	 */
	private String resourceCode;

	/**
	 * 所属系统;
	 */
	private String systemCode;

	/**
	 * 资源名称;
	 */
	private String name;

	/**
	 * 资源类型; 目录 0；菜单 1；按钮 ：2
	 */
	private String type;

	@TableField(exist = false)
//	@MergeField(key = "SYS_RESOURCE_TYPE", targetKey = "type", feign = StaticFeignClient.class, method = "merge")
	private String typeV;

	/**
	 * 路劲;
	 */
	private String path;

	/**
	 * 资源链接;
	 */
	private String url;
	
	/**
	 * 资源icon;
	 */
	private String icon;
	
	/**
	 * 资源iconName;
	 */
	private String iconName;

	/**
	 * 父节点;
	 */
	private Long parentId;

	/**
	 * 父节点 Code;
	 */
	private String parentResourceCode;


	/**
	 * 权限编码;
	 */
	private String permission;

	/**
	 * 是否可用;
	 */
	private String available;

	/**
	 * 顺序号
	 */
	private Integer seq;

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
	private List<SysResource> children;

	@TableField(exist = false)
	private String parentName;
	
	@TableField(exist = false)
	private Boolean checked;

	@TableField(exist = false)
	private String selectedResourceCode;

}
