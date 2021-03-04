package com.cloud.user.fegin.server.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

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
public class SysUserPageFeign implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int page = 1;
	private int size = 5;
	
	private String userName;
	
	private Integer locked;
	private List<String> userCodes;
	
	private String userMobile;
	
	private String isWork;
	
	private String userAccount;
	
	private String systemType;
	
}
