package com.cloud.reptile.dto.mediation.organization;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 项目名称：spring-cloud-service
 * 类 名 称：MediationOrganizationDTO
 * 类 描 述：TODO
 * 创建时间：2021/2/27 下午2:19
 * 创 建 人：chenyouhong
 */
@NoArgsConstructor
@Data
public class MediationOrganizationDTO {


    /**
     * code : 1
     * description : null
     * secretKey : null
     * result : {"next":2,"last":204,"lastPage":false,"totalPage":204,"prev":1,"count":1835,"firstResult":0,"pageSize":9,"resultData":[{"openOnline":false,"isDeleted":0,"province":"520000","city":"520100","county":"520123","name":"景阳街道清溪村村民委员会人民调解委员会","id":"DD23EC717031E3BDA7E2BA119466E5B3"},{"openOnline":false,"isDeleted":0,"province":"520000","city":"520100","county":"520123","name":"景阳街道和新村村民委员会人民调解委员会","id":"905F70E1830216F953C0CA5D90F26E06"},{"openOnline":false,"isDeleted":0,"province":"520000","city":"520100","county":"520123","name":"景阳街道香巴湖村村民委员会人民调解委员会","id":"150B290D92C55A992D7F71E7870B88D4"},{"openOnline":false,"isDeleted":0,"province":"520000","city":"520100","county":"520123","name":"景阳街道红星村村民委员会人民调解委员会","telephone":"13984157940","id":"FFF0710B591F42C127F7828789826610"},{"openOnline":false,"isDeleted":0,"province":"520000","city":"520100","county":"520123","name":"修文县景阳街道人民调解委员会","id":"558C32A7222F0F7FBCD570A3B9386940"},{"openOnline":false,"isDeleted":0,"province":"520000","city":"520100","county":"520123","name":"修文县龙岗社区龙潭居民委员会人民调解委员会","id":"1D4E2391F26336C69A6B5A48FDEFA7AE"},{"openOnline":false,"address":"云岩区贝地卢加诺后冲街8号","isDeleted":0,"province":"520000","city":"520100","county":"520103","name":"贵阳市云岩区金龙社区贝地人民调委会","telephone":"84819543","id":"74782368F63E706756BC55925B3B4528","completeAddress":"贵州省贵阳市云岩区1112"},{"openOnline":false,"isDeleted":0,"province":"520000","city":"520100","county":"520113","name":"贵阳市白云区艳山红社区白金居委会人民调解委员会","telephone":"139840225716","id":"384782F242110CFDEADAE17D475ADB4F"},{"openOnline":false,"isDeleted":0,"province":"520000","city":"520100","county":"520115","name":"观山湖区金府居委会人民调解委员会","id":"B80F5A4FC69EDEE269048EF551912703"}],"funcName":"page","firstPage":true,"maxResults":9,"pageNo":1,"notCount":false,"disabled":false,"first":1}
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
         * next : 2
         * last : 204
         * lastPage : false
         * totalPage : 204
         * prev : 1
         * count : 1835
         * firstResult : 0
         * pageSize : 9
         * resultData : [{"openOnline":false,"isDeleted":0,"province":"520000","city":"520100","county":"520123","name":"景阳街道清溪村村民委员会人民调解委员会","id":"DD23EC717031E3BDA7E2BA119466E5B3"},{"openOnline":false,"isDeleted":0,"province":"520000","city":"520100","county":"520123","name":"景阳街道和新村村民委员会人民调解委员会","id":"905F70E1830216F953C0CA5D90F26E06"},{"openOnline":false,"isDeleted":0,"province":"520000","city":"520100","county":"520123","name":"景阳街道香巴湖村村民委员会人民调解委员会","id":"150B290D92C55A992D7F71E7870B88D4"},{"openOnline":false,"isDeleted":0,"province":"520000","city":"520100","county":"520123","name":"景阳街道红星村村民委员会人民调解委员会","telephone":"13984157940","id":"FFF0710B591F42C127F7828789826610"},{"openOnline":false,"isDeleted":0,"province":"520000","city":"520100","county":"520123","name":"修文县景阳街道人民调解委员会","id":"558C32A7222F0F7FBCD570A3B9386940"},{"openOnline":false,"isDeleted":0,"province":"520000","city":"520100","county":"520123","name":"修文县龙岗社区龙潭居民委员会人民调解委员会","id":"1D4E2391F26336C69A6B5A48FDEFA7AE"},{"openOnline":false,"address":"云岩区贝地卢加诺后冲街8号","isDeleted":0,"province":"520000","city":"520100","county":"520103","name":"贵阳市云岩区金龙社区贝地人民调委会","telephone":"84819543","id":"74782368F63E706756BC55925B3B4528","completeAddress":"贵州省贵阳市云岩区1112"},{"openOnline":false,"isDeleted":0,"province":"520000","city":"520100","county":"520113","name":"贵阳市白云区艳山红社区白金居委会人民调解委员会","telephone":"139840225716","id":"384782F242110CFDEADAE17D475ADB4F"},{"openOnline":false,"isDeleted":0,"province":"520000","city":"520100","county":"520115","name":"观山湖区金府居委会人民调解委员会","id":"B80F5A4FC69EDEE269048EF551912703"}]
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
             * openOnline : false
             * isDeleted : 0
             * province : 520000
             * city : 520100
             * county : 520123
             * name : 景阳街道清溪村村民委员会人民调解委员会
             * id : DD23EC717031E3BDA7E2BA119466E5B3
             * telephone : 13984157940
             * address : 云岩区贝地卢加诺后冲街8号
             * completeAddress : 贵州省贵阳市云岩区1112
             */

            @JsonProperty("openOnline")
            private Boolean openOnline;
            @JsonProperty("isDeleted")
            private Integer isDeleted;
            @JsonProperty("province")
            private String province;
            @JsonProperty("city")
            private String city;
            @JsonProperty("county")
            private String county;
            @JsonProperty("name")
            private String name;
            @JsonProperty("id")
            private String id;
            @JsonProperty("telephone")
            private String telephone;
            @JsonProperty("address")
            private String address;
            @JsonProperty("completeAddress")
            private String completeAddress;
        }
    }
}
