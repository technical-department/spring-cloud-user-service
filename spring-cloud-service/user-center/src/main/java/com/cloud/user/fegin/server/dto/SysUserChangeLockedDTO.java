package com.cloud.user.fegin.server.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * Title: SysUserRestPwdDTO
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2018-05-16
 */
@Data
public class SysUserChangeLockedDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "用户id为空")
	private Long id;
	@NotNull(message = "状态为空")
	private String locked;

}
