package com.cloud.reptile.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:律师事务所
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_law_firm")
public class LawFirm implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "law_firm_id", type = IdType.AUTO)
    private Integer lawFirmid;

    /**
     * 自增id
     */
    private String id;

    /**
     * 律所名称
     */
    private String name;

    /**
     * 统一社会信用代码
     */
    private String licenseNumber;

    /**
     * 组织编码
     */
    private String organizeNumber;

    /**
     * 成立时间
     */
    private Date issueDate;

    /**
     * 律师事务所主任
     */
    private String directorName;

    /**
     * 主管司法行政机关
     */
    private String justiceBureauName;

    /**
     * 电 话
     */
    private String telephone;

    /**
     * 服务邮箱
     */
    private String email;

    /**
     * 邮编
     */
    private String postcode;

    /**
     * 律师事务所简介
     */
    private String introduction;

    /**
     * 所在省
     */
    private String province;

    /**
     * 所在市
     */
    private String city;

    /**
     * 所在区
     */
    private String county;

    /**
     * 地 址
     */
    private String address;

    /**
     * 省
     */
    private String provinceName;

    /**
     * 市
     */
    private String cityName;

    /**
     * 区
     */
    private String countyName;

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
