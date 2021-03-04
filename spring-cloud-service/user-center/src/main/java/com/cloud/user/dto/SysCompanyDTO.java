package com.cloud.user.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * Title: SysCompanyDTO
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2021-02-16
 */
@Data
public class SysCompanyDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 公司编码
     */
    private String companyCode;

    /**
     * 公司全称
     */
    private String companyName;

    /**
     * 公司简称
     */
    private String companySimpleName;

}
