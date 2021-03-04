package com.cloud.user.fegin.server.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class SysUserAddSaleDTO {
	
	@NotBlank(message = "用户名为空")
	private String userName;
	@NotBlank(message = "工号为空")
	private String userCode;
	private String userAccount;
	private String userSex;
	@NotBlank(message = "手机号为空")
//	@Pattern(regexp = ValidUtils.mobile, message = "手机号格式不正确")
	private String userMobile;
//	@Pattern(regexp = ValidUtils.email, message = "E-MAIL格式错误")
	@Email
	private String userEmail;
	@NotBlank(message = "所属系统为空")
	private String systemCode;
	@NotBlank(message = "身份证为空")
	private String idno;
	private List<Long> positionIds;
    private Date inductionDate;
	private String parentUserCode;
	
	private Integer locked;
	private String userPwd;
	/**
	 * 1 为外部人员
	 */
	private String external;
	
	private List<Long> roleIds;
	
	

}
