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
 * Description:基层法律服务所1111
 * </p>
 * @author chenyouhong
 * @date 2021-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GrassrootLegalServicePageOut implements Serializable {

    private static final long serialVersionUID = 1L;
    

    /**
     * 自增id
     */
    private Integer grassrootLegalServiceId;

    /**
     * id
     */
    private String id;

    /**
     * 基层法律服务名称
     */
    private String name;

    /**
     * 注册号
     */
    private String licenseNumber;

    /**
     * 统一社会信用代码
     */
    private String organizeNumber;

    /**
     * 成立时间
     */
    private Date issueDate;

    /**
     * 法定代表人或负责人
     */
    private String directorName;

    /**
     * admLevel
     */
    private String admLevel;

    /**
     * 主管司法行政机关id
     */
    private String justiceBureauId;

    /**
     * 主管司法行政机关
     */
    private String justiceBureauName;

    /**
     * 组织形式
     */
    private String organizationForms;

    /**
     * 电 话
     */
    private String telephone;

    /**
     * 服务邮箱
     */
    private String email;

    /**
     * 律师事务所简介
     */
    private String introduction;

    /**
     * 成立时间
     */
    private Date setupDate;

    /**
     * practiceArea
     */
    private String practiceArea;

    /**
     * practiceStatus
     */
    private String practiceStatus;

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
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;

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


