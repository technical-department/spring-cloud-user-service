package com.cloud.user.model;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * Title: SysCompany
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2021-02-16
 */
@Data
@TableName("sys_company")
public class SysCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id;     
     */
    private Long id;

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

    /**
     * 公司地址;     
     */
    private String businessAddress;

    /**
     * 座机电话;     
     */
    private String businessTel;

    /**
     * 公司邮箱;     
     */
    private String businessEmail;

    /**
     * 所在省;     
     */
    private String businessProvince;

    /**
     * 所在市;     
     */
    private String businessCity;

    /**
     * 所在区;     
     */
    private String businessCounty;

    /**
     * 营业执照注册号;     
     */
    private String businessLicenseNo;

    /**
     * 主要联系人姓名;     
     */
    private String mainContactName;

    /**
     * 主要联系人手机号;     
     */
    private String mainContactMobile;

    /**
     * 主要联系人邮箱;     
     */
    private String mainContactEmail;

    /**
     * 次要联系人姓名;     
     */
    private String otherContactName;

    /**
     * 次要联系人邮箱;     
     */
    private String otherContactMobile;

    /**
     * 次要联系人手机号;     
     */
    private String otherContactEmail;

    /**
     * 创建人;     
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间;     
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    /**
     * 更新人;     
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 更新时间;     
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;


}
