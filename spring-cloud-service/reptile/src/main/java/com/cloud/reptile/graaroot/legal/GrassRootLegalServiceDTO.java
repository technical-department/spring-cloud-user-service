package com.cloud.reptile.graaroot.legal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 项目名称：spring-cloud-service
 * 类 名 称：GrassRootLegalServiceDTO
 * 类 描 述：TODO
 * 创建时间：2021/2/27 下午7:45
 * 创 建 人：chenyouhong
 */
@NoArgsConstructor
@Data
public class GrassRootLegalServiceDTO {


    /**
     * code : 1
     * description : null
     * secretKey : null
     * result : {"next":2,"last":4,"lastPage":false,"totalPage":4,"prev":1,"count":34,"firstResult":0,"pageSize":9,"resultData":[{"organizationForms":"普通合伙","address":"息烽县养龙司镇和平路司法所院内","city":"520100","justiceBureauId":"82a83839a56143faa82450f105b2c7a1","county":"520122","publicStatus":true,"telephone":"18685018503","organizeNumber":"33520000MD31527449","staffNumber":2,"setupDate":1490630400000,"cityName":"贵阳市","isDeleted":0,"province":"520000","directorName":"姜艳","name":"息烽县养龙司法律服务所","admLevel":"946131a907d3444bb130744434e230a9","licenseNumber":"33520000MD31527449","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"19112194D2T5CH94","provinceName":"贵州省","countyName":"息烽县"},{"organizationForms":"其他","address":"息烽县小寨坝磷城北路2-3号","city":"520100","justiceBureauId":"82a83839a56143faa82450f105b2c7a1","county":"520122","publicStatus":true,"telephone":"13984136501","organizeNumber":"335200003563594873","staffNumber":3,"setupDate":1003161600000,"cityName":"贵阳市","isDeleted":0,"province":"520000","directorName":"张导临","name":"息烽县小寨坝法律服务所","admLevel":"946131a907d3444bb130744434e230a9","licenseNumber":"335200003563594873","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"19112193GWRA1ZF8","provinceName":"贵州省","countyName":"息烽县"},{"organizationForms":"其他","address":"息烽县永靖镇南大街1号楼33号门面","city":"520100","justiceBureauId":"82a83839a56143faa82450f105b2c7a1","county":"520122","publicStatus":true,"telephone":"13984168123","organizeNumber":"33520000429962034A","staffNumber":5,"setupDate":994262400000,"cityName":"贵阳市","isDeleted":0,"province":"520000","directorName":"袁军","name":"息烽县中心法律服务所","admLevel":"946131a907d3444bb130744434e230a9","licenseNumber":"33520000429962034A","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"19112192CATB9FRP","provinceName":"贵州省","countyName":"息烽县"},{"organizationForms":"其他","address":"息烽县永靖镇虎城大道商业一条街20号","city":"520100","justiceBureauId":"82a83839a56143faa82450f105b2c7a1","county":"520122","publicStatus":true,"telephone":"13985168394","organizeNumber":"33520000MD31543441","staffNumber":8,"setupDate":1338393600000,"cityName":"贵阳市","isDeleted":0,"province":"520000","directorName":"杨秀红","name":"息烽县永靖法律服务所","admLevel":"946131a907d3444bb130744434e230a9","licenseNumber":"33520000MD31543441","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"19112190W5P2K400","provinceName":"贵州省","introduction":"息烽县永靖镇法律服务所于1997年成立，属县司法局下设的国有所，办公地点在息烽县永靖镇辖区，办所以来坚持做到以事实为依据，以法律为准则，全心全意为当事人服务；做到求真务实优质高效、维护当事人利益；做到为国家机关，企事业单位、个体户等保驾护航，有法律本科4人、法律专科4人，专业执业人员7人，兼职1人，具有丰富的工作经验、代理了民事、行政、刑事自诉、非诉案件，参与政府调解，担任政府法律顾问。本着服务政府，服务社会，服务当事人的宗指，用高标准，高起点，树立本所良好形象，为人民满意的法律服务所。","countyName":"息烽县"},{"city":"520100","justiceBureauId":"c0d9f9f67e6b417ab5644f1f3b9d7fe4","county":"520102","publicStatus":true,"staffNumber":19,"cityName":"贵阳市","isDeleted":0,"province":"520000","name":"安顺市镇宁自治县中心法律服务所","admLevel":"3c541c60093544fd88659e94b59ef02c","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"190522CY85A7PP6W","provinceName":"贵州省","countyName":"南明区"},{"city":"520100","justiceBureauId":"c0d9f9f67e6b417ab5644f1f3b9d7fe4","county":"520102","publicStatus":true,"staffNumber":13,"cityName":"贵阳市","isDeleted":0,"province":"520000","name":"安顺市镇宁自治县诚信法律服务所","admLevel":"3c541c60093544fd88659e94b59ef02c","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"190522CY86B7RNMW","provinceName":"贵州省","countyName":"南明区"},{"city":"520100","justiceBureauId":"8332f6d9b48942879ae143498ff385f7","county":"520115","publicStatus":true,"staffNumber":3,"cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵阳市金华法律服务所","admLevel":"d516abb01a9c471bb937b5397a3e61d8","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"190522CY6X9SR6Y8","provinceName":"贵州省","countyName":"观山湖区"},{"city":"520100","justiceBureauId":"8332f6d9b48942879ae143498ff385f7","county":"520115","publicStatus":true,"staffNumber":4,"cityName":"贵阳市","isDeleted":0,"province":"520000","name":"修文县维正法律服务所","admLevel":"d516abb01a9c471bb937b5397a3e61d8","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"190522CY6ZZX5KP0","provinceName":"贵州省","countyName":"观山湖区"},{"organizationForms":"民间组织","address":"云岭东路39号3喽","city":"520100","justiceBureauId":"b4b4a078077b417baa6f6a92c0b0bc06","county":"520181","postcode":"551400","publicStatus":true,"organizeNumber":"520181030304080001","staffNumber":9,"setupDate":1052755200000,"cityName":"贵阳市","isDeleted":0,"province":"520000","name":"清镇市红枫湖镇法律服务所","admLevel":"bf34aeca48bd478bb147c864d3441852","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"00960f96a50447c588660c48b310742b","provinceName":"贵州省","countyName":"清镇市"}],"funcName":"page","firstPage":true,"maxResults":9,"pageNo":1,"notCount":false,"disabled":false,"first":1}
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
         * last : 4
         * lastPage : false
         * totalPage : 4
         * prev : 1
         * count : 34
         * firstResult : 0
         * pageSize : 9
         * resultData : [{"organizationForms":"普通合伙","address":"息烽县养龙司镇和平路司法所院内","city":"520100","justiceBureauId":"82a83839a56143faa82450f105b2c7a1","county":"520122","publicStatus":true,"telephone":"18685018503","organizeNumber":"33520000MD31527449","staffNumber":2,"setupDate":1490630400000,"cityName":"贵阳市","isDeleted":0,"province":"520000","directorName":"姜艳","name":"息烽县养龙司法律服务所","admLevel":"946131a907d3444bb130744434e230a9","licenseNumber":"33520000MD31527449","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"19112194D2T5CH94","provinceName":"贵州省","countyName":"息烽县"},{"organizationForms":"其他","address":"息烽县小寨坝磷城北路2-3号","city":"520100","justiceBureauId":"82a83839a56143faa82450f105b2c7a1","county":"520122","publicStatus":true,"telephone":"13984136501","organizeNumber":"335200003563594873","staffNumber":3,"setupDate":1003161600000,"cityName":"贵阳市","isDeleted":0,"province":"520000","directorName":"张导临","name":"息烽县小寨坝法律服务所","admLevel":"946131a907d3444bb130744434e230a9","licenseNumber":"335200003563594873","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"19112193GWRA1ZF8","provinceName":"贵州省","countyName":"息烽县"},{"organizationForms":"其他","address":"息烽县永靖镇南大街1号楼33号门面","city":"520100","justiceBureauId":"82a83839a56143faa82450f105b2c7a1","county":"520122","publicStatus":true,"telephone":"13984168123","organizeNumber":"33520000429962034A","staffNumber":5,"setupDate":994262400000,"cityName":"贵阳市","isDeleted":0,"province":"520000","directorName":"袁军","name":"息烽县中心法律服务所","admLevel":"946131a907d3444bb130744434e230a9","licenseNumber":"33520000429962034A","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"19112192CATB9FRP","provinceName":"贵州省","countyName":"息烽县"},{"organizationForms":"其他","address":"息烽县永靖镇虎城大道商业一条街20号","city":"520100","justiceBureauId":"82a83839a56143faa82450f105b2c7a1","county":"520122","publicStatus":true,"telephone":"13985168394","organizeNumber":"33520000MD31543441","staffNumber":8,"setupDate":1338393600000,"cityName":"贵阳市","isDeleted":0,"province":"520000","directorName":"杨秀红","name":"息烽县永靖法律服务所","admLevel":"946131a907d3444bb130744434e230a9","licenseNumber":"33520000MD31543441","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"19112190W5P2K400","provinceName":"贵州省","introduction":"息烽县永靖镇法律服务所于1997年成立，属县司法局下设的国有所，办公地点在息烽县永靖镇辖区，办所以来坚持做到以事实为依据，以法律为准则，全心全意为当事人服务；做到求真务实优质高效、维护当事人利益；做到为国家机关，企事业单位、个体户等保驾护航，有法律本科4人、法律专科4人，专业执业人员7人，兼职1人，具有丰富的工作经验、代理了民事、行政、刑事自诉、非诉案件，参与政府调解，担任政府法律顾问。本着服务政府，服务社会，服务当事人的宗指，用高标准，高起点，树立本所良好形象，为人民满意的法律服务所。","countyName":"息烽县"},{"city":"520100","justiceBureauId":"c0d9f9f67e6b417ab5644f1f3b9d7fe4","county":"520102","publicStatus":true,"staffNumber":19,"cityName":"贵阳市","isDeleted":0,"province":"520000","name":"安顺市镇宁自治县中心法律服务所","admLevel":"3c541c60093544fd88659e94b59ef02c","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"190522CY85A7PP6W","provinceName":"贵州省","countyName":"南明区"},{"city":"520100","justiceBureauId":"c0d9f9f67e6b417ab5644f1f3b9d7fe4","county":"520102","publicStatus":true,"staffNumber":13,"cityName":"贵阳市","isDeleted":0,"province":"520000","name":"安顺市镇宁自治县诚信法律服务所","admLevel":"3c541c60093544fd88659e94b59ef02c","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"190522CY86B7RNMW","provinceName":"贵州省","countyName":"南明区"},{"city":"520100","justiceBureauId":"8332f6d9b48942879ae143498ff385f7","county":"520115","publicStatus":true,"staffNumber":3,"cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵阳市金华法律服务所","admLevel":"d516abb01a9c471bb937b5397a3e61d8","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"190522CY6X9SR6Y8","provinceName":"贵州省","countyName":"观山湖区"},{"city":"520100","justiceBureauId":"8332f6d9b48942879ae143498ff385f7","county":"520115","publicStatus":true,"staffNumber":4,"cityName":"贵阳市","isDeleted":0,"province":"520000","name":"修文县维正法律服务所","admLevel":"d516abb01a9c471bb937b5397a3e61d8","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"190522CY6ZZX5KP0","provinceName":"贵州省","countyName":"观山湖区"},{"organizationForms":"民间组织","address":"云岭东路39号3喽","city":"520100","justiceBureauId":"b4b4a078077b417baa6f6a92c0b0bc06","county":"520181","postcode":"551400","publicStatus":true,"organizeNumber":"520181030304080001","staffNumber":9,"setupDate":1052755200000,"cityName":"贵阳市","isDeleted":0,"province":"520000","name":"清镇市红枫湖镇法律服务所","admLevel":"bf34aeca48bd478bb147c864d3441852","practiceStatus":"39a62a49a44341a7942b34b9ac9e90a9","id":"00960f96a50447c588660c48b310742b","provinceName":"贵州省","countyName":"清镇市"}]
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
             * organizationForms : 普通合伙
             * address : 息烽县养龙司镇和平路司法所院内
             * city : 520100
             * justiceBureauId : 82a83839a56143faa82450f105b2c7a1
             * county : 520122
             * publicStatus : true
             * telephone : 18685018503
             * organizeNumber : 33520000MD31527449
             * staffNumber : 2
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
             * introduction : 息烽县永靖镇法律服务所于1997年成立，属县司法局下设的国有所，办公地点在息烽县永靖镇辖区，办所以来坚持做到以事实为依据，以法律为准则，全心全意为当事人服务；做到求真务实优质高效、维护当事人利益；做到为国家机关，企事业单位、个体户等保驾护航，有法律本科4人、法律专科4人，专业执业人员7人，兼职1人，具有丰富的工作经验、代理了民事、行政、刑事自诉、非诉案件，参与政府调解，担任政府法律顾问。本着服务政府，服务社会，服务当事人的宗指，用高标准，高起点，树立本所良好形象，为人民满意的法律服务所。
             * postcode : 551400
             */

            @JsonProperty("organizationForms")
            private String organizationForms;
            @JsonProperty("address")
            private String address;
            @JsonProperty("city")
            private String city;
            @JsonProperty("justiceBureauId")
            private String justiceBureauId;
            @JsonProperty("county")
            private String county;
            @JsonProperty("publicStatus")
            private Boolean publicStatus;
            @JsonProperty("telephone")
            private String telephone;
            @JsonProperty("organizeNumber")
            private String organizeNumber;
            @JsonProperty("staffNumber")
            private Integer staffNumber;
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
            @JsonProperty("introduction")
            private String introduction;
            @JsonProperty("postcode")
            private String postcode;
        }
    }
}
