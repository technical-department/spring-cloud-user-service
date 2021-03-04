package com.cloud.reptile.dto;

import lombok.Data;

/**
 * 项目名称：spring-cloud-service
 * 类 名 称：ChinaRegionsInfo
 * 类 描 述：TODO
 * 创建时间：2021/2/26 下午8:49
 * 创 建 人：chenyouhong
 */
@Data
public class ChinaRegionsInfo {
    /**
     * 行政区域编码
     */
    private String code;

    /**
     * 行政区域名称
     */
    private String name;

    /**
     * 行政区域类型，1:省份，2：城市，3：区或者县城
     */
    private Integer type;

    /**
     * 上一级行政区域编码
     */
    private String parentCode;

}