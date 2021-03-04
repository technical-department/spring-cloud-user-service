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
 * Description:法律援助中心
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_legal_aid_agency")
public class LegalAidAgency implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "laywer_id", type = IdType.AUTO)
    private Integer laywerId;

    /**
     * id
     */
    private String id;

    /**
     * 机构名称
     */
    private String name;

    /**
     * 行政级别
     */
    private String admLevel;

    /**
     * 电 话
     */
    private String telephone;

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
     * 地 址
     */
    private String completeAddress;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;

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
