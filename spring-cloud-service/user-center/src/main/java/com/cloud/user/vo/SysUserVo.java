package com.cloud.user.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * Title: SysUserPageIn
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2018-05-16
 */
@Data
public class SysUserVo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int current = 1;
	private int size = 5;
	
//	private String userCode;
	
	private String userAccount;

	private String userName;
	
	private Integer locked;
	
	private String systemCode;
//	
	private String departCode;
//	
	private String systemType;
	
	private String userMobile;
	
	private String isWork;
	
}
