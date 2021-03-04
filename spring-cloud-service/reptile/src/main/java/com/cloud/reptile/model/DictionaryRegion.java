package com.cloud.reptile.model;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:地区国标
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_dictionary_region")
public class DictionaryRegion implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 地区编码
     */
    private String code;

    /**
     * 地区名字
     */
    private String name;

    /**
     * 0：省、直辖市、1 市辖区、市、2 区县
     */
    private Integer level;

    private String regex;

    /**
     * 父节点
     */
    private String parentCode;

    private String remark;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String parent;


}
