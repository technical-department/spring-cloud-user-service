package com.cloud.reptile.graaroot.legal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 项目名称：spring-cloud-service
 * 类 名 称：GrassRootLegalServiceDetailDTO
 * 类 描 述：TODO
 * 创建时间：2021/2/27 下午7:48
 * 创 建 人：chenyouhong
 */
@NoArgsConstructor
@Data
public class GrassRootLegalServiceDetailDTO {


    /**
     * code : 1
     * description : null
     * secretKey : null
     * result : {"organizationForms":"普通合伙","address":"息烽县养龙司镇和平路司法所院内","city":"520100","justiceBureauId":"82a83839a56143faa82450f105b2c7a1","practiceArea":"6e3aeea42406445e9e481930257c17cb","county":"520122","evaluates":[],"publicStatus":true,"telephone":"18685018503","services":[],"staffNumber":2,"justiceBureauName":"息烽县司法局","setupDate":1490630400000,"cityName":"贵阳市","isDeleted":0,"province":"520000","directorName":"姜艳","name":"息烽县养龙司法律服务所","admLevel":"946131a907d3444bb130744434e230a9","licenseNumber":"33520000MD31527449","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"19112194D2T5CH94","provinceName":"贵州省","countyName":"息烽县"}
     * exception : null
     * success : true
     */

    @JsonProperty("code")
    private Integer code;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("secretKey")
    private Object secretKey;
    @JsonProperty("result")
    private ResultDTO result;
    @JsonProperty("exception")
    private Object exception;
    @JsonProperty("success")
    private Boolean success;

    @NoArgsConstructor
    @Data
    public static class ResultDTO {
        /**
         * organizationForms : 普通合伙
         * address : 息烽县养龙司镇和平路司法所院内
         * city : 520100
         * justiceBureauId : 82a83839a56143faa82450f105b2c7a1
         * practiceArea : 6e3aeea42406445e9e481930257c17cb
         * county : 520122
         * evaluates : []
         * publicStatus : true
         * telephone : 18685018503
         * services : []
         * staffNumber : 2
         * justiceBureauName : 息烽县司法局
         * setupDate : 1490630400000
         * cityName : 贵阳市
         * isDeleted : 0
         * province : 520000
         * directorName : 姜艳
         * name : 息烽县养龙司法律服务所
         * admLevel : 946131a907d3444bb130744434e230a9
         * licenseNumber : 33520000MD31527449
         * practiceStatus : 39a62a49a44341a7942b34b9ac9e90a9
         * id : 19112194D2T5CH94
         * provinceName : 贵州省
         * countyName : 息烽县
         */

        @JsonProperty("organizationForms")
        private String organizationForms;
        @JsonProperty("address")
        private String address;
        @JsonProperty("city")
        private String city;
        @JsonProperty("justiceBureauId")
        private String justiceBureauId;
        @JsonProperty("practiceArea")
        private String practiceArea;
        @JsonProperty("county")
        private String county;
        @JsonProperty("evaluates")
        private List<?> evaluates;
        @JsonProperty("publicStatus")
        private Boolean publicStatus;
        @JsonProperty("telephone")
        private String telephone;
        @JsonProperty("services")
        private List<?> services;
        @JsonProperty("staffNumber")
        private Integer staffNumber;
        @JsonProperty("justiceBureauName")
        private String justiceBureauName;
        @JsonProperty("setupDate")
        private Long setupDate;
        @JsonProperty("cityName")
        private String cityName;
        @JsonProperty("isDeleted")
        private Integer isDeleted;
        @JsonProperty("province")
        private String province;
        @JsonProperty("directorName")
        private String directorName;
        @JsonProperty("name")
        private String name;
        @JsonProperty("admLevel")
        private String admLevel;
        @JsonProperty("licenseNumber")
        private String licenseNumber;
        @JsonProperty("practiceStatus")
        private String practiceStatus;
        @JsonProperty("id")
        private String id;
        @JsonProperty("provinceName")
        private String provinceName;
        @JsonProperty("countyName")
        private String countyName;
    }

}
