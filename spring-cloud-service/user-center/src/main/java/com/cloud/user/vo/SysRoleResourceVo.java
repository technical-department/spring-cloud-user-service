package com.cloud.user.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * Title: SysRoleResourcesAddDTO
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2018-05-21
 */
@Data
public class SysRoleResourceVo implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * role_code
     */
    @NotBlank(message="roleCode必填")
    private String roleCode;

    /**
     * resource_code;
     */
    @NotEmpty(message="资源组至少有一个")
    private List<String> resourceCodes;

}
