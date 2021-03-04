package com.cloud.user.dto;

import lombok.Data;

import java.util.List;

@Data
public class CompanyAndDepartmentDTO {
	
	private String companyCode;
	
	private String companyName;
	
	private String companySimpleName;
	
	private String departCode;
	
	private String departName;
	
	private String parentDepartCode;

	List<CompanyAndDepartmentDTO> children;
	

}
