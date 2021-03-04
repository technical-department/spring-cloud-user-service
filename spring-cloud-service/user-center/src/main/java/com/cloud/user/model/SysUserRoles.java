package com.cloud.user.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * Title: SysUserRoles
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2021-02-16
 */
@Data
@TableName("sys_user_roles")
public class SysUserRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id;     
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户code;
     */
    private String userCode;

    /**
     * user_id;
     */
    private Long userId;

    /**
     * 角色code;
     */
    private String roleCode;

    /**
     * role_id;     
     */
    private Long roleId;

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
