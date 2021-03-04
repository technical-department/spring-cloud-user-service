package com.cloud.user.fegin.server.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class SysUserSaleUpdDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @NotBlank(message = "userCode为空")
	private String userCode;
    @NotBlank(message = "用户名为空")
	private String userName;
	private String userSex;
//	@Pattern(regexp = ValidUtils.mobile, message = "手机号格式不正确")
	private String userMobile;
//	@Pattern(regexp = ValidUtils.email, message = "E-MAIL格式错误")
	@Email
	private String userEmail;
	private String idno;
	private List<Long> positionIds;
	private String locked;
    private Date inductionDate;
    private String parentUserCode;
    
	
}
