package com.cloud.reptile.dto;

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
 * Description:调解机构1111
 * </p>
 * @author chenyouhong
 * @date 2021-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MediationOrganizationDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    

    /**
     * id
     */
    private String id;
    

    /**
     * 律所名称
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
     * 主管司法行政机关id
     */
    private String justiceBureauId;
    

    /**
     * 主管司法行政机关
     */
    private String justiceBureauName;
    

    /**
     * 电 话
     */
    private String telephone;
    

    /**
     * 简介
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
     * 地 址
     */
    private String completeAddress;
    

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
