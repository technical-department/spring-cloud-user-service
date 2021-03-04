package com.cloud.user.fegin.server.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 增加推荐码
 */
@Data
public class AddRCode implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userCode;
	private String attrCode;
	private String rcode;

}
