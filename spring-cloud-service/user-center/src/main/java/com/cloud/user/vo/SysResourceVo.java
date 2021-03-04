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
public class SysResourceVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资源编码;
     */
    private String resourceCode;

    /**
     * 所属系统;     
     */
    @NotBlank(message="所属系统编码为空")
    private String systemCode;

    /**
     * 资源名称;
     */
    @NotBlank(message="资源名称为空")
    private String name;

    /**
     * 资源类型;
     */
    @NotBlank(message="资源类型为空")
    private String type;

    /**
     * url;
     */
    private String url;

    /**
     * url;
     */
    @NotBlank(message="路径为空")
    private String path;

    /**
     *
     * 权限码;
     */
    private String permission;

    /**
     *
     * icon;
     */
    private String icon;

    /**
     * 父节点;
     */
    private String parentResourceCode;

    /**
     * 状态;
     */
    private String available;

    /**
     * 顺序号
     */
    private Integer seq;

}
