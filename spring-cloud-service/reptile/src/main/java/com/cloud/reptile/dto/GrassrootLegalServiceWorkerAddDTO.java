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
 * Description:法律服务工作者1111
 * </p>
 * @author chenyouhong
 * @date 2021-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GrassrootLegalServiceWorkerAddDTO implements Serializable {

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
     * 律师执业证号
     */
    private String licenseNumber;
    

    /**
     * 律师资格证号
     */
    private String qualificationCertificateNumber;
    

    /**
     * 主管司法行政机关
     */
    private String justiceBureauName;
    

    /**
     * 主管司法行政机关id
     */
    private String justiceBureauId;
    

    /**
     * 学历
     */
    private String education;
    

    /**
     * 发证时间
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
     * 拼音
     */
    private String namePinyin;
    

    /**
     * nation
     */
    private String nation;
    

    /**
     * 机构id
     */
    private String orgId;
    

    /**
     * 机构电话
     */
    private String orgTelephone;
    

    /**
     * personId
     */
    private String personId;
    

    /**
     * politic
     */
    private String politic;
    

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
