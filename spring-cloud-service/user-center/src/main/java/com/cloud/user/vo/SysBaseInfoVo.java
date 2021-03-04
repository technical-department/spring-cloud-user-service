package com.cloud.user.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysBaseInfoVo implements Serializable {

	private Long id;

	/**
	 * 系统名称;
	 */
	private String systemName;

	/**
	 * 系统类型;     1：管理系统，2：前端系统 3：第三方系统
	 */
	private String systemType;

	private String indexUrl;

	/**
	 * 系统编码
	 */
	private String systemCode;

	/**
	 * 系统前缀
	 */
	private String systemPrefix;


	private int current = 1;

	private int size = 5;

}
