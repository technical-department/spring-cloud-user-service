package com.cloud.user.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RoleInfo implements Serializable {
	
	private String id;

	/**
	 * 角色code;
	 */
	@JSONField(name = "code")
	private String roleCode;

	/**
	 * 所属系统;
	 */
	private String systemCode;

	/**
	 * 角色名称;
	 */
	@JSONField(name = "name")
	private String roleName;

	/**
	 * 描述;
	 */
	private String roleMark;

	/**
	 * 状态;
	 */
	private Integer status;


}
