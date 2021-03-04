package com.cloud.user.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * Title: SysPositionRole
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2021-02-16
 */
@Data
@TableName("sys_position_role")
public class SysPositionRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id;     
     */
    private Long id;

    /**
     * 岗位id
     */
    private Long positionId;

    /**
     * 岗位code
     */
    private String positionCode;

    /**
     * role_id;     
     */
    private Long roleId;

    /**
     * 角色code;
     */
    private String roleCode;

    /**
     * 创建人;     
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间;     
     */

    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    /**
     * 更新人;     
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 更新时间;     
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;


}
