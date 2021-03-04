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
 * Description:调解员1111
 * </p>
 * @author chenyouhong
 * @date 2021-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MediatorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    

    /**
     * id
     */
    private String id;
    

    /**
     * 调解机构名称
     */
    private String orgName;
    

    /**
     * 名称
     */
    private String name;
    

    /**
     * 教育
     */
    private String education;
    

    /**
     * 性别  0:女  1:男
     */
    private String gender;
    

    /**
     * 电 话
     */
    private String telephone;
    

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
