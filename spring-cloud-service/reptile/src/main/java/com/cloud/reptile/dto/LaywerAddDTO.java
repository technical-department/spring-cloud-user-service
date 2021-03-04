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
 * Description:律师1111
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LaywerAddDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    

    /**
     * id
     */
    private String id;
    

    /**
     * 姓名
     */
    private String name;
    

    /**
     * 生日
     */
    private Date birthday;
    

    /**
     * 律师执业证号
     */
    private String licenseNumber;
    

    /**
     * 律师资格证号
     */
    private String qualificationCertificateNumber;
    

    /**
     * 律师服务邮箱
     */
    private String email;
    

    /**
     * 律师图片
     */
    private String photo;
    

    /**
     * 首次从事律师执业时间
     */
    private Date firstPracticeDate;
    

    /**
     * 律所服务电话
     */
    private String lawfirmTelephone;
    

    /**
     * 电 话
     */
    private String telephone;
    

    /**
     * 所内身份
     */
    private String inhouseIdentity;
    

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
