package com.cloud.reptile.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:鉴定员
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class IdentifierUpdDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    private Integer identifierId;

    /**
     * id
     */
    private String id;

    /**
     * 机构id
     */
    private String orgId;

    /**
     * 名称
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 执业证号
     */
    private String licenseNumber;

    /**
     * 电 话
     */
    private String telephone;

    /**
     * 开始时间
     */
    private Date licenseStartDate;

    /**
     * 结束时间
     */
    private Date licenseEndDate;

    /**
     * 名称
     */
    private String certificateType;

    /**
     * 状态
     */
    private Integer isDeleted;

    /**
     * 类型（暂未用）
     */
    private String type;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;


}
