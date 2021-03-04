package com.cloud.user.fegin.server.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 绑定身份证
 * <p>
 * Description:
 * </p>
 * @author Sine
 * @date 2019年11月26日
 */
@Data
public class BindIdno implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userCode;
	private String userName;
	private String idno;

}
