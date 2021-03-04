package com.cloud.reptile.dto.mediation.organization;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 项目名称：spring-cloud-service
 * 类 名 称：MediationOrganizationDetailDTO
 * 类 描 述：TODO
 * 创建时间：2021/2/27 下午2:21
 * 创 建 人：chenyouhong
 */
@NoArgsConstructor
@Data
public class MediationOrganizationDetailDTO {


    /**
     * code : 1
     * description : null
     * secretKey : null
     * result : {"openOnline":false,"address":"贵州省黔南布依族苗族自治州都匀市归兰水族乡阳和片区","city":"522700","justiceBureauId":"598ce9d1e10e4335916f200e46380648","county":"522701","telephone":"15985403938","axis":"106.712761,26.579543","justiceBureauName":"都匀市司法局归兰司法所","isDeleted":0,"province":"520000","name":"归兰水族乡人民调解委员会","id":"2101278MZYTWKYW0","completeAddress":"贵州省黔南布依族苗族自治州都匀市归兰水族乡贵州省黔南布依族苗族自治州都匀市归兰水族乡阳和片区"}
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
         * openOnline : false
         * address : 贵州省黔南布依族苗族自治州都匀市归兰水族乡阳和片区
         * city : 522700
         * justiceBureauId : 598ce9d1e10e4335916f200e46380648
         * county : 522701
         * telephone : 15985403938
         * axis : 106.712761,26.579543
         * justiceBureauName : 都匀市司法局归兰司法所
         * isDeleted : 0
         * province : 520000
         * name : 归兰水族乡人民调解委员会
         * id : 2101278MZYTWKYW0
         * completeAddress : 贵州省黔南布依族苗族自治州都匀市归兰水族乡贵州省黔南布依族苗族自治州都匀市归兰水族乡阳和片区
         */

        @JsonProperty("openOnline")
        private Boolean openOnline;
        @JsonProperty("address")
        private String address;
        @JsonProperty("city")
        private String city;
        @JsonProperty("justiceBureauId")
        private String justiceBureauId;
        @JsonProperty("county")
        private String county;
        @JsonProperty("telephone")
        private String telephone;
        @JsonProperty("axis")
        private String axis;
        @JsonProperty("justiceBureauName")
        private String justiceBureauName;
        @JsonProperty("isDeleted")
        private Integer isDeleted;
        @JsonProperty("province")
        private String province;
        @JsonProperty("name")
        private String name;
        @JsonProperty("id")
        private String id;
        @JsonProperty("completeAddress")
        private String completeAddress;
    }

}
