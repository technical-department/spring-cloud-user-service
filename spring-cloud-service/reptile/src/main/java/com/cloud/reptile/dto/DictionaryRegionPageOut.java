package com.cloud.reptile.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:地区国标1111
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DictionaryRegionPageOut implements Serializable {

    private static final long serialVersionUID = 1L;
    

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


