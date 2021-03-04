package com.cloud.user.fegin.server.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class SysUserAddSaleRolesDTO {
	@NotBlank(message = "userCode为空")
	private String userCode;
	
	@NotEmpty(message = "roleIds为空")
	private List<Long> roleIds;

}
