package com.cloud.user.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SystemBaseInfo implements Serializable {
	
	private String id;

	/**
	 * 系统名称;
	 */
	@JSONField(name = "name")
	private String systemName;

	/**
	 * 系统类型;     0：管理系统，1：前端系统 2：第三方系统
	 */
	private String systemType;

	/**
	 * 系统编码
	 */
	@JSONField(name = "code")
	private String systemCode;
	
	private List<RoleInfo> children;

}
