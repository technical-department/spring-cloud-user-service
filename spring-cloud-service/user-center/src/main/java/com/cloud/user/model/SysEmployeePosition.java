package com.cloud.user.model;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * Title: SysEmployeePosition
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2018-06-08
 */
@Data
@TableName("sys_employee_position")
public class SysEmployeePosition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String userCode;

    private String managerCode;

    private String positionCode;

    private Long positionId;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;


}
