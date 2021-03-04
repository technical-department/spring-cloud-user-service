package com.cloud.reptile.dto.authentication.organization;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 项目名称：spring-cloud-service
 * 类 名 称：AuthenticationOrganizationDTO
 * 类 描 述：TODO
 * 创建时间：2021/2/26 下午11:59
 * 创 建 人：chenyouhong
 */
@NoArgsConstructor
@Data
public class AuthenticationOrganizationDTO {

    /**
     * code : 1
     * description : null
     * secretKey : null
     * result : {"next":2,"last":2,"lastPage":false,"totalPage":2,"prev":1,"count":20,"firstResult":0,"pageSize":10,"resultData":[{"address":"贵州省贵阳市南明区凤凰路116号","city":"520100","telephone":"0851-85112047","serviceTime":"9:00-17:00","creditCode":"11520000429202190H","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵州省司法警察医院法医学司法鉴定所","licenseNumber":"11520000429202190H","serviceScope":"法医临床司法鉴定","id":"11520000429202190H","provinceName":"贵州省","validStartDate":1601481600000,"validEndDate":1759248000000},{"address":"贵阳市白云区白沙路388号","city":"520100","telephone":"0851-85892760","serviceTime":"9:00-17:00","creditCode":"12520000429200654L","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵州省检测技术研究应用中心司法鉴定中心","licenseNumber":"12520000429200654L","serviceScope":"微量物证司法鉴定(金属及其合金、矿物、化工产品、化肥、植物及其制品、食品、饮料、添加剂及包装材料、工程复合材料及制品、建筑材料鉴定),污染物性质鉴定(仅限固体废物鉴定、危险废物鉴定、有毒物质（不包括危险废物）鉴定、污染物筛查及理化性质鉴定),土壤与地下水环境损害鉴定(地下水污染致植物损害鉴定、地下水污染致动物损害鉴定除外),地表水和沉积物环境损害鉴定,法医毒物司法鉴定","id":"12520000429200654L","provinceName":"贵州省","validStartDate":1601481600000,"validEndDate":1759248000000},{"address":"贵阳市观山湖区黔灵山路217号","city":"520100","telephone":"0851-85500958","serviceTime":"9:00-17:00","creditCode":"125200004292016650","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵州省环境科学研究设计院环境损害司法鉴定中心","licenseNumber":"125200004292016650","serviceScope":"土壤与地下水环境损害鉴定,地表水和沉积物环境损害鉴定,空气污染环境损害鉴定,污染物性质鉴定,其他环境损害鉴定","id":"125200004292016650","provinceName":"贵州省","validStartDate":1515427200000,"validEndDate":1673193600000},{"address":"贵阳市云岩区北京路9号","city":"520100","telephone":"0851-86908728","serviceTime":"9:00-17:00","creditCode":"125200004292028528","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵州医科大学法医司法鉴定中心","licenseNumber":"125200004292028528","serviceScope":"法医病理司法鉴定,法医物证司法鉴定,法医临床司法鉴定,法医毒物司法鉴定","id":"125200004292028528","provinceName":"贵州省","validStartDate":1601481600000,"validEndDate":1759248000000},{"address":"贵州省贵阳市云岩区新添大道南段206号","city":"520100","telephone":"0851-86771390","serviceTime":"9:00-17:00","creditCode":"12520000429202991Y","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵州省第二人民医院法医精神病鉴定中心","licenseNumber":"12520000429202991Y","serviceScope":"法医精神病司法鉴定","id":"12520000429202991Y","provinceName":"贵州省","validStartDate":1601481600000,"validEndDate":1759248000000},{"address":"贵阳市宝山北路116号","city":"520100","telephone":"085186701986","serviceTime":"9:00-17:00","creditCode":"125200004292035218","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵州师范大学物证司法鉴定所","licenseNumber":"125200004292035218","serviceScope":"痕迹司法鉴定(工具痕迹、整体分离痕迹、交通事故痕迹司法鉴定),微量物证司法鉴定,法医毒物司法鉴定","id":"125200004292035218","provinceName":"贵州省","validStartDate":1492358400000,"validEndDate":1650124800000},{"address":"贵阳市南明区中山东路83号","city":"520100","telephone":"0851-85607086","serviceTime":"9:00-17:00","creditCode":"12520000429247882E","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵州省人民医院法医司法鉴定所","licenseNumber":"12520000429247882E","serviceScope":"法医临床司法鉴定","id":"12520000429247882E","provinceName":"贵州省","validStartDate":1492185600000,"validEndDate":1649952000000},{"address":"贵阳市安云路樱花巷18号","city":"520100","telephone":"085186839944","serviceTime":"9:00-17:00","creditCode":"12520000429248121L","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵州省妇幼保健院司法鉴定所","licenseNumber":"12520000429248121L","serviceScope":"法医物证司法鉴定","id":"12520000429248121L","provinceName":"贵州省","validStartDate":1601568000000,"validEndDate":1759248000000},{"address":"贵阳市博爱路1-3号","city":"520100","telephone":"0851-88302664","serviceTime":"9:00-17:00","creditCode":"125201004292500023","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵阳市第一人民医院法医司法鉴定所","licenseNumber":"125201004292500023","serviceScope":"法医临床司法鉴定","id":"125201004292500023","provinceName":"贵州省","validStartDate":1519488000000,"validEndDate":1677168000000},{"address":"贵州省贵阳市云岩区枣山路雄骏国际大厦24层","city":"520100","telephone":"0851-85919222","serviceTime":"9:00-17:00","creditCode":"34520000MD8010008M","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵州中一司法鉴定中心","licenseNumber":"34520000MD8010008M","serviceScope":"法医病理司法鉴定,法医物证司法鉴定,法医临床司法鉴定(听觉功能、视觉功能、性功能除外),痕迹司法鉴定,法医毒物司法鉴定,文书司法鉴定(笔迹鉴定、印章鉴定、印刷文件、朱墨时序),声像资料司法鉴定(录音资料鉴定、图像资料鉴定、电子数据鉴定)","id":"34520000MD8010008M","provinceName":"贵州省","validStartDate":1609862400000,"validEndDate":1767542400000}],"funcName":"page","firstPage":true,"maxResults":10,"pageNo":1,"notCount":false,"disabled":false,"first":1}
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
         * last : 2
         * lastPage : false
         * totalPage : 2
         * prev : 1
         * count : 20
         * firstResult : 0
         * pageSize : 10
         * resultData : [{"address":"贵州省贵阳市南明区凤凰路116号","city":"520100","telephone":"0851-85112047","serviceTime":"9:00-17:00","creditCode":"11520000429202190H","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵州省司法警察医院法医学司法鉴定所","licenseNumber":"11520000429202190H","serviceScope":"法医临床司法鉴定","id":"11520000429202190H","provinceName":"贵州省","validStartDate":1601481600000,"validEndDate":1759248000000},{"address":"贵阳市白云区白沙路388号","city":"520100","telephone":"0851-85892760","serviceTime":"9:00-17:00","creditCode":"12520000429200654L","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵州省检测技术研究应用中心司法鉴定中心","licenseNumber":"12520000429200654L","serviceScope":"微量物证司法鉴定(金属及其合金、矿物、化工产品、化肥、植物及其制品、食品、饮料、添加剂及包装材料、工程复合材料及制品、建筑材料鉴定),污染物性质鉴定(仅限固体废物鉴定、危险废物鉴定、有毒物质（不包括危险废物）鉴定、污染物筛查及理化性质鉴定),土壤与地下水环境损害鉴定(地下水污染致植物损害鉴定、地下水污染致动物损害鉴定除外),地表水和沉积物环境损害鉴定,法医毒物司法鉴定","id":"12520000429200654L","provinceName":"贵州省","validStartDate":1601481600000,"validEndDate":1759248000000},{"address":"贵阳市观山湖区黔灵山路217号","city":"520100","telephone":"0851-85500958","serviceTime":"9:00-17:00","creditCode":"125200004292016650","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵州省环境科学研究设计院环境损害司法鉴定中心","licenseNumber":"125200004292016650","serviceScope":"土壤与地下水环境损害鉴定,地表水和沉积物环境损害鉴定,空气污染环境损害鉴定,污染物性质鉴定,其他环境损害鉴定","id":"125200004292016650","provinceName":"贵州省","validStartDate":1515427200000,"validEndDate":1673193600000},{"address":"贵阳市云岩区北京路9号","city":"520100","telephone":"0851-86908728","serviceTime":"9:00-17:00","creditCode":"125200004292028528","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵州医科大学法医司法鉴定中心","licenseNumber":"125200004292028528","serviceScope":"法医病理司法鉴定,法医物证司法鉴定,法医临床司法鉴定,法医毒物司法鉴定","id":"125200004292028528","provinceName":"贵州省","validStartDate":1601481600000,"validEndDate":1759248000000},{"address":"贵州省贵阳市云岩区新添大道南段206号","city":"520100","telephone":"0851-86771390","serviceTime":"9:00-17:00","creditCode":"12520000429202991Y","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵州省第二人民医院法医精神病鉴定中心","licenseNumber":"12520000429202991Y","serviceScope":"法医精神病司法鉴定","id":"12520000429202991Y","provinceName":"贵州省","validStartDate":1601481600000,"validEndDate":1759248000000},{"address":"贵阳市宝山北路116号","city":"520100","telephone":"085186701986","serviceTime":"9:00-17:00","creditCode":"125200004292035218","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵州师范大学物证司法鉴定所","licenseNumber":"125200004292035218","serviceScope":"痕迹司法鉴定(工具痕迹、整体分离痕迹、交通事故痕迹司法鉴定),微量物证司法鉴定,法医毒物司法鉴定","id":"125200004292035218","provinceName":"贵州省","validStartDate":1492358400000,"validEndDate":1650124800000},{"address":"贵阳市南明区中山东路83号","city":"520100","telephone":"0851-85607086","serviceTime":"9:00-17:00","creditCode":"12520000429247882E","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵州省人民医院法医司法鉴定所","licenseNumber":"12520000429247882E","serviceScope":"法医临床司法鉴定","id":"12520000429247882E","provinceName":"贵州省","validStartDate":1492185600000,"validEndDate":1649952000000},{"address":"贵阳市安云路樱花巷18号","city":"520100","telephone":"085186839944","serviceTime":"9:00-17:00","creditCode":"12520000429248121L","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵州省妇幼保健院司法鉴定所","licenseNumber":"12520000429248121L","serviceScope":"法医物证司法鉴定","id":"12520000429248121L","provinceName":"贵州省","validStartDate":1601568000000,"validEndDate":1759248000000},{"address":"贵阳市博爱路1-3号","city":"520100","telephone":"0851-88302664","serviceTime":"9:00-17:00","creditCode":"125201004292500023","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵阳市第一人民医院法医司法鉴定所","licenseNumber":"125201004292500023","serviceScope":"法医临床司法鉴定","id":"125201004292500023","provinceName":"贵州省","validStartDate":1519488000000,"validEndDate":1677168000000},{"address":"贵州省贵阳市云岩区枣山路雄骏国际大厦24层","city":"520100","telephone":"0851-85919222","serviceTime":"9:00-17:00","creditCode":"34520000MD8010008M","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵州中一司法鉴定中心","licenseNumber":"34520000MD8010008M","serviceScope":"法医病理司法鉴定,法医物证司法鉴定,法医临床司法鉴定(听觉功能、视觉功能、性功能除外),痕迹司法鉴定,法医毒物司法鉴定,文书司法鉴定(笔迹鉴定、印章鉴定、印刷文件、朱墨时序),声像资料司法鉴定(录音资料鉴定、图像资料鉴定、电子数据鉴定)","id":"34520000MD8010008M","provinceName":"贵州省","validStartDate":1609862400000,"validEndDate":1767542400000}]
         * funcName : page
         * firstPage : true
         * maxResults : 10
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
        @JsonProperty("result")
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
             * address : 贵州省贵阳市南明区凤凰路116号
             * city : 520100
             * telephone : 0851-85112047
             * serviceTime : 9:00-17:00
             * creditCode : 11520000429202190H
             * cityName : 贵阳市
             * isDeleted : 0
             * province : 520000
             * name : 贵州省司法警察医院法医学司法鉴定所
             * licenseNumber : 11520000429202190H
             * serviceScope : 法医临床司法鉴定
             * id : 11520000429202190H
             * provinceName : 贵州省
             * validStartDate : 1601481600000
             * validEndDate : 1759248000000
             */

            @JsonProperty("address")
            private String address;
            @JsonProperty("city")
            private String city;
            @JsonProperty("telephone")
            private String telephone;
            @JsonProperty("serviceTime")
            private String serviceTime;
            @JsonProperty("creditCode")
            private String creditCode;
            @JsonProperty("cityName")
            private String cityName;
            @JsonProperty("isDeleted")
            private Integer isDeleted;
            @JsonProperty("province")
            private String province;
            @JsonProperty("name")
            private String name;
            @JsonProperty("licenseNumber")
            private String licenseNumber;
            @JsonProperty("serviceScope")
            private String serviceScope;
            @JsonProperty("id")
            private String id;
            @JsonProperty("provinceName")
            private String provinceName;
            @JsonProperty("validStartDate")
            private Long validStartDate;
            @JsonProperty("validEndDate")
            private Long validEndDate;
        }
    }
}
