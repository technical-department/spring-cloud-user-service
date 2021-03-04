package com.cloud.user.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * Title: SysDepartmentPosition
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2021-02-16
 */
@Data
@TableName("sys_department_position")
public class SysDepartmentPosition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String positionCode;

    private String departCode;

    private String positionName;

    private Long parentId;

    private String managerCode;

    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;
	
	@TableField(exist = false)
	private String departName;
	
	@TableField(exist = false)
	private List<Long> roleIds;
	
	@TableField(exist = false)
	private List<SysDepartmentPosition> childs;

	@TableField(exist = false)
	private String parentName;


}
