package com.cloud.user.fegin.client.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 请求参数
 * 
 * @author sine
 *
 */
@Data
public class IdentifyParam implements Serializable {
	/**
	 * 
	 */
	@NotBlank(message = "businessCode is empty")
	private String businessCode;
	@NotBlank(message = "name is empty")
	private String name;
	@NotBlank(message = "mobile is empty")
	private String mobile;
	@NotBlank(message = "idno is empty")
	private String idno;

}
