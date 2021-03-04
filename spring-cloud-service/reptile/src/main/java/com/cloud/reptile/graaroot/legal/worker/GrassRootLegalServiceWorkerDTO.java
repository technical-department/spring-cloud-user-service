package com.cloud.reptile.graaroot.legal.worker;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 项目名称：spring-cloud-service
 * 类 名 称：GrassRootLegalServiceWorkerDTO
 * 类 描 述：TODO
 * 创建时间：2021/2/27 下午7:54
 * 创 建 人：chenyouhong
 */
@NoArgsConstructor
@Data
public class GrassRootLegalServiceWorkerDTO {


    /**
     * code : 1
     * description : null
     * secretKey : null
     * result : {"next":1,"last":1,"lastPage":true,"totalPage":1,"prev":1,"count":2,"firstResult":0,"pageSize":9,"resultData":[{"address":"息烽县养龙司镇和平路司法所院内","gender":"e10d702b89d849e789039de65cd268cd","city":"520100","nation":"add2e15654b24079aab1579794f93a46","county":"520122","publicStatus":true,"orgTelephone":"18685018503","firstPracticeDate":1442678400000,"orgId":"19112194D2T5CH94","jaglsOrganizationInfo":{"organizationForms":"普通合伙","address":"息烽县养龙司镇和平路司法所院内","city":"520100","justiceBureauId":"82a83839a56143faa82450f105b2c7a1","practiceArea":"6e3aeea42406445e9e481930257c17cb","county":"520122","publicStatus":true,"telephone":"18685018503","staffNumber":2,"justiceBureauName":"息烽县司法局","setupDate":1490630400000,"cityName":"贵阳市","isDeleted":0,"province":"520000","directorName":"姜艳","name":"息烽县养龙司法律服务所","admLevel":"946131a907d3444bb130744434e230a9","licenseNumber":"33520000MD31527449","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"19112194D2T5CH94","provinceName":"贵州省","countyName":"息烽县"},"cityName":"贵阳市","isDeleted":0,"province":"520000","jaglsOrganization":"19112194D2T5CH94","politic":"1c624e8f217d459fa63e54fbdbfb15c3","jaglsOrganizationName":"息烽县养龙司法律服务所","name":"姜艳","licenseNumber":"32401152100917","id":"191121AA1XNMRR8H","provinceName":"贵州省","countyName":"息烽县"},{"address":"息烽县养龙司镇和平路司法所院内","gender":"e10d702b89d849e789039de65cd268cd","city":"520100","nation":"add2e15654b24079aab1579794f93a46","county":"520122","publicStatus":true,"orgTelephone":"18685018503","firstPracticeDate":1403193600000,"orgId":"19112194D2T5CH94","jaglsOrganizationInfo":{"organizationForms":"普通合伙","address":"息烽县养龙司镇和平路司法所院内","city":"520100","justiceBureauId":"82a83839a56143faa82450f105b2c7a1","practiceArea":"6e3aeea42406445e9e481930257c17cb","county":"520122","publicStatus":true,"telephone":"18685018503","staffNumber":2,"justiceBureauName":"息烽县司法局","setupDate":1490630400000,"cityName":"贵阳市","isDeleted":0,"province":"520000","directorName":"姜艳","name":"息烽县养龙司法律服务所","admLevel":"946131a907d3444bb130744434e230a9","licenseNumber":"33520000MD31527449","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"19112194D2T5CH94","provinceName":"贵州省","countyName":"息烽县"},"cityName":"贵阳市","isDeleted":0,"province":"520000","jaglsOrganization":"19112194D2T5CH94","politic":"1c624e8f217d459fa63e54fbdbfb15c3","jaglsOrganizationName":"息烽县养龙司法律服务所","name":"张忠菊","licenseNumber":"32401142100919","id":"191121AADGAPHTF8","provinceName":"贵州省","countyName":"息烽县"}],"funcName":"page","firstPage":true,"maxResults":9,"pageNo":1,"notCount":false,"disabled":false,"first":1}
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
         * next : 1
         * last : 1
         * lastPage : true
         * totalPage : 1
         * prev : 1
         * count : 2
         * firstResult : 0
         * pageSize : 9
         * resultData : [{"address":"息烽县养龙司镇和平路司法所院内","gender":"e10d702b89d849e789039de65cd268cd","city":"520100","nation":"add2e15654b24079aab1579794f93a46","county":"520122","publicStatus":true,"orgTelephone":"18685018503","firstPracticeDate":1442678400000,"orgId":"19112194D2T5CH94","jaglsOrganizationInfo":{"organizationForms":"普通合伙","address":"息烽县养龙司镇和平路司法所院内","city":"520100","justiceBureauId":"82a83839a56143faa82450f105b2c7a1","practiceArea":"6e3aeea42406445e9e481930257c17cb","county":"520122","publicStatus":true,"telephone":"18685018503","staffNumber":2,"justiceBureauName":"息烽县司法局","setupDate":1490630400000,"cityName":"贵阳市","isDeleted":0,"province":"520000","directorName":"姜艳","name":"息烽县养龙司法律服务所","admLevel":"946131a907d3444bb130744434e230a9","licenseNumber":"33520000MD31527449","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"19112194D2T5CH94","provinceName":"贵州省","countyName":"息烽县"},"cityName":"贵阳市","isDeleted":0,"province":"520000","jaglsOrganization":"19112194D2T5CH94","politic":"1c624e8f217d459fa63e54fbdbfb15c3","jaglsOrganizationName":"息烽县养龙司法律服务所","name":"姜艳","licenseNumber":"32401152100917","id":"191121AA1XNMRR8H","provinceName":"贵州省","countyName":"息烽县"},{"address":"息烽县养龙司镇和平路司法所院内","gender":"e10d702b89d849e789039de65cd268cd","city":"520100","nation":"add2e15654b24079aab1579794f93a46","county":"520122","publicStatus":true,"orgTelephone":"18685018503","firstPracticeDate":1403193600000,"orgId":"19112194D2T5CH94","jaglsOrganizationInfo":{"organizationForms":"普通合伙","address":"息烽县养龙司镇和平路司法所院内","city":"520100","justiceBureauId":"82a83839a56143faa82450f105b2c7a1","practiceArea":"6e3aeea42406445e9e481930257c17cb","county":"520122","publicStatus":true,"telephone":"18685018503","staffNumber":2,"justiceBureauName":"息烽县司法局","setupDate":1490630400000,"cityName":"贵阳市","isDeleted":0,"province":"520000","directorName":"姜艳","name":"息烽县养龙司法律服务所","admLevel":"946131a907d3444bb130744434e230a9","licenseNumber":"33520000MD31527449","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"19112194D2T5CH94","provinceName":"贵州省","countyName":"息烽县"},"cityName":"贵阳市","isDeleted":0,"province":"520000","jaglsOrganization":"19112194D2T5CH94","politic":"1c624e8f217d459fa63e54fbdbfb15c3","jaglsOrganizationName":"息烽县养龙司法律服务所","name":"张忠菊","licenseNumber":"32401142100919","id":"191121AADGAPHTF8","provinceName":"贵州省","countyName":"息烽县"}]
         * funcName : page
         * firstPage : true
         * maxResults : 9
         * pageNo : 1
         * notCount : false
         * disabled : false
         * first : 1
         */

        @JsonProperty("next")
        private Integer next;
        @JsonProperty("last")
        private Integer last;
        @JsonProperty("lastPage")
        private Boolean lastPage;
        @JsonProperty("totalPage")
        private Integer totalPage;
        @JsonProperty("prev")
        private Integer prev;
        @JsonProperty("count")
        private Integer count;
        @JsonProperty("firstResult")
        private Integer firstResult;
        @JsonProperty("pageSize")
        private Integer pageSize;
        @JsonProperty("resultData")
        private List<ResultDataDTO> result;
        @JsonProperty("funcName")
        private String funcName;
        @JsonProperty("firstPage")
        private Boolean firstPage;
        @JsonProperty("maxResults")
        private Integer maxResults;
        @JsonProperty("pageNo")
        private Integer pageNo;
        @JsonProperty("notCount")
        private Boolean notCount;
        @JsonProperty("disabled")
        private Boolean disabled;
        @JsonProperty("first")
        private Integer first;

        @NoArgsConstructor
        @Data
        public static class ResultDataDTO {
            /**
             * address : 息烽县养龙司镇和平路司法所院内
             * gender : e10d702b89d849e789039de65cd268cd
             * city : 520100
             * nation : add2e15654b24079aab1579794f93a46
             * county : 520122
             * publicStatus : true
             * orgTelephone : 18685018503
             * firstPracticeDate : 1442678400000
             * orgId : 19112194D2T5CH94
             * jaglsOrganizationInfo : {"organizationForms":"普通合伙","address":"息烽县养龙司镇和平路司法所院内","city":"520100","justiceBureauId":"82a83839a56143faa82450f105b2c7a1","practiceArea":"6e3aeea42406445e9e481930257c17cb","county":"520122","publicStatus":true,"telephone":"18685018503","staffNumber":2,"justiceBureauName":"息烽县司法局","setupDate":1490630400000,"cityName":"贵阳市","isDeleted":0,"province":"520000","directorName":"姜艳","name":"息烽县养龙司法律服务所","admLevel":"946131a907d3444bb130744434e230a9","licenseNumber":"33520000MD31527449","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"19112194D2T5CH94","provinceName":"贵州省","countyName":"息烽县"}
             * cityName : 贵阳市
             * isDeleted : 0
             * province : 520000
             * jaglsOrganization : 19112194D2T5CH94
             * politic : 1c624e8f217d459fa63e54fbdbfb15c3
             * jaglsOrganizationName : 息烽县养龙司法律服务所
             * name : 姜艳
             * licenseNumber : 32401152100917
             * id : 191121AA1XNMRR8H
             * provinceName : 贵州省
             * countyName : 息烽县
             */

            @JsonProperty("address")
            private String address;
            @JsonProperty("gender")
            private String gender;
            @JsonProperty("city")
            private String city;
            @JsonProperty("nation")
            private String nation;
            @JsonProperty("county")
            private String county;
            @JsonProperty("publicStatus")
            private Boolean publicStatus;
            @JsonProperty("orgTelephone")
            private String orgTelephone;
            @JsonProperty("firstPracticeDate")
            private Long firstPracticeDate;
            @JsonProperty("orgId")
            private String orgId;
            @JsonProperty("jaglsOrganizationInfo")
            private JaglsOrganizationInfoDTO jaglsOrganizationInfo;
            @JsonProperty("cityName")
            private String cityName;
            @JsonProperty("isDeleted")
            private Integer isDeleted;
            @JsonProperty("province")
            private String province;
            @JsonProperty("jaglsOrganization")
            private String jaglsOrganization;
            @JsonProperty("politic")
            private String politic;
            @JsonProperty("jaglsOrganizationName")
            private String jaglsOrganizationName;
            @JsonProperty("name")
            private String name;
            @JsonProperty("licenseNumber")
            private String licenseNumber;
            @JsonProperty("id")
            private String id;
            @JsonProperty("provinceName")
            private String provinceName;
            @JsonProperty("countyName")
            private String countyName;

            @NoArgsConstructor
            @Data
            public static class JaglsOrganizationInfoDTO {
                /**
                 * organizationForms : 普通合伙
                 * address : 息烽县养龙司镇和平路司法所院内
                 * city : 520100
                 * justiceBureauId : 82a83839a56143faa82450f105b2c7a1
                 * practiceArea : 6e3aeea42406445e9e481930257c17cb
                 * county : 520122
                 * publicStatus : true
                 * telephone : 18685018503
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
                @JsonProperty("publicStatus")
                private Boolean publicStatus;
                @JsonProperty("telephone")
                private String telephone;
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
    }
}
