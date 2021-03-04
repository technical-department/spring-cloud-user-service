package com.cloud.oauth.feign.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户编码;
	 */
	private String userCode;

	/**
	 * 是否 可用
	 */
	private Integer status;
	
	private String name;

}
