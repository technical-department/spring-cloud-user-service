package com.cloud.user.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * Title: SysRoleResources
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2018-05-21
 */
@Data
@TableName("sys_role_resources")
public class SysRoleResources implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * role_id
     */
    private Long roleId;

    /**
     * role_code
     */
    private String roleCode;

    /**
     * resource_code;
     */
    private String resourceCode;

    /**
     * resource_id;     
     */
    private Long resourceId;

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


}
