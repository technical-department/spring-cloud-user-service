package com.cloud.user.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * Title: SysRoleAddDTO
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2018-05-17
 */
@Data
public class SysRoleVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所属系统;     
     */
    @NotBlank(message="所属系统编码为空")
    private String systemCode;

    /**
     * 角色名称;     
     */
    @NotBlank(message="角色名称为空")
    private String roleName;

    /**
     * 描述;     
     */
    private String roleRemark;

}
