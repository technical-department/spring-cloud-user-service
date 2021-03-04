package com.cloud.user.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * Title: SysBaseInfo
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2021-02-10
 */
@Data
@TableName("sys_base_info")
public class SysBaseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id;     
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 系统名称;     
     */
    private String systemName;

    /**
     * 系统类型;     0：管理系统，1：前端系统 2：第三方系统
     */
    private String systemType;

    /**
     * 系统编码
     */
    private String systemCode;

    /**
     * 系统前缀
     */
    private String systemPrefix;
    
    
    private String indexUrl;

    /**
     * 创建人;     
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间;     
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新人;     
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 更新时间;     
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(exist = false)
    private List<SysRole> children;

}
