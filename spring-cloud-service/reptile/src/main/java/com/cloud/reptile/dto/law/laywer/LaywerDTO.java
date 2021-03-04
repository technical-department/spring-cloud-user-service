package com.cloud.reptile.dto.law.laywer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Data
public class LaywerDTO {


    /**
     * code : 1
     * description : null
     * secretKey : null
     * result : {"next":1,"last":1,"lastPage":true,"totalPage":1,"prev":1,"count":5,"firstResult":0,"pageSize":9,"resultData":[{"birthday":273859200000,"education":"de3f058bc9844263995d59631eb3db9a","lawfirm":"520102010103010001","gender":"0f33f0f8cdaf48d0b0cd9522756db346","city":"520100","nation":"add2e15654b24079aab1579794f93a46","lawfirmAddress":"贵州省贵阳市南明区贵州省贵阳市南明区花果园中央商务区F4栋","county":"520102","lawyerTitle":"aba9bae5db4f4fb88d470bad27bd4e82","justiceBureauName":"南明区司法局","lawfirmTelephone":"0851-85954445","isDeleted":0,"nationLanguage":"16d04df9cbd445d49c0e8ab6d2c2f29c","post":"a93ff3557aff45a2a13f0576d370d50c","province":"520000","licenseNumber":"15201201110910757","practiceStatus":"01","id":"5201020101020100020084","email":"359120437@qq.com","address":"贵阳市白云区金园路69号","business":[],"justiceBureauId":"38719bb7a917441a9b787de63da114c7","photo":"201228FD2B5HF140","publicStatus":true,"telephone":"18608509621","inhouseIdentity":"聘用专职律师","qualificationCertificateNumber":"A20085201133377","firstPracticeDate":1294502400000,"practiceType":"01","lawyerTeamFlag":-1,"name":"戴斌","lawfirmName":"贵州佰益律师事务所"},{"birthday":147024000000,"education":"de3f058bc9844263995d59631eb3db9a","lawfirm":"520102010103010001","gender":"0f33f0f8cdaf48d0b0cd9522756db346","city":"520100","nation":"add2e15654b24079aab1579794f93a46","lawfirmAddress":"贵州省贵阳市南明区贵州省贵阳市南明区花果园中央商务区F4栋","county":"520102","lawyerTitle":"aba9bae5db4f4fb88d470bad27bd4e82","justiceBureauName":"南明区司法局","lawfirmTelephone":"0851-85954445","isDeleted":0,"nationLanguage":"16d04df9cbd445d49c0e8ab6d2c2f29c","post":"a93ff3557aff45a2a13f0576d370d50c","province":"520000","politic":"1c624e8f217d459fa63e54fbdbfb15c3","licenseNumber":"15201200910147755","practiceStatus":"01","id":"5201020101020100020085","email":"1121009546@qq.com","address":"贵州省贵阳市南明区","business":[],"justiceBureauId":"38719bb7a917441a9b787de63da114c7","photo":"2012250YRNTDR77C","publicStatus":true,"telephone":"13639125982","inhouseIdentity":"负责人","qualificationCertificateNumber":"A20065201140041","firstPracticeDate":1231430400000,"practiceType":"01","lawyerTeamFlag":-1,"name":"胡勇","lawfirmName":"贵州佰益律师事务所"},{"birthday":815673600000,"education":"de3f058bc9844263995d59631eb3db9a","lawfirm":"520102010103010001","gender":"0f33f0f8cdaf48d0b0cd9522756db346","city":"520100","nation":"add2e15654b24079aab1579794f93a46","lawfirmAddress":"贵州省贵阳市南明区贵州省贵阳市南明区花果园中央商务区F4栋","county":"520102","lawyerTitle":"aba9bae5db4f4fb88d470bad27bd4e82","justiceBureauName":"南明区司法局","lawfirmTelephone":"0851-85954445","isDeleted":0,"nationLanguage":"16d04df9cbd445d49c0e8ab6d2c2f29c","post":"a93ff3557aff45a2a13f0576d370d50c","province":"520000","licenseNumber":"15201202010187254","practiceStatus":"01","id":"200515HRKTPMBA14","address":"贵州省贵阳市南明区太慈桥国际城","business":[],"justiceBureauId":"38719bb7a917441a9b787de63da114c7","photo":"201228F714MT0YCH","publicStatus":true,"telephone":"13120567560","inhouseIdentity":"聘用专职律师","qualificationCertificateNumber":"A20175201020859","firstPracticeDate":1589385600000,"practiceType":"01","lawyerTeamFlag":-1,"name":"罗新","lawfirmName":"贵州佰益律师事务所"},{"birthday":747331200000,"lawfirm":"520102010103010001","gender":"0f33f0f8cdaf48d0b0cd9522756db346","city":"520100","nation":"f2a88916be994159af6708470728ae7b","lawfirmAddress":"贵州省贵阳市南明区贵州省贵阳市南明区花果园中央商务区F4栋","county":"520102","lawyerTitle":"aba9bae5db4f4fb88d470bad27bd4e82","justiceBureauName":"南明区司法局","lawfirmTelephone":"0851-85954445","isDeleted":0,"nationLanguage":"16d04df9cbd445d49c0e8ab6d2c2f29c","post":"a93ff3557aff45a2a13f0576d370d50c","province":"520000","politic":"1c624e8f217d459fa63e54fbdbfb15c3","licenseNumber":"15201201710275713","practiceStatus":"01","id":"5201020101020100020847","email":"2549313545@qq.com","address":"贵阳市南明区花果园中央商务区4栋一单元25层33号","business":[],"justiceBureauId":"38719bb7a917441a9b787de63da114c7","photo":"2012250SHTP4BFK4","publicStatus":true,"telephone":"18798607318","inhouseIdentity":"聘用专职律师","qualificationCertificateNumber":"B20155226330003","firstPracticeDate":1501430400000,"practiceType":"01","lawyerTeamFlag":-1,"name":"姚红光","lawfirmName":"贵州佰益律师事务所"},{"birthday":553273200000,"education":"de3f058bc9844263995d59631eb3db9a","lawfirm":"520102010103010001","gender":"e10d702b89d849e789039de65cd268cd","city":"520100","nation":"add2e15654b24079aab1579794f93a46","lawfirmAddress":"贵州省贵阳市南明区贵州省贵阳市南明区花果园中央商务区F4栋","county":"520102","lawyerTitle":"aba9bae5db4f4fb88d470bad27bd4e82","justiceBureauName":"南明区司法局","lawfirmTelephone":"0851-85954445","isDeleted":0,"nationLanguage":"16d04df9cbd445d49c0e8ab6d2c2f29c","post":"a93ff3557aff45a2a13f0576d370d50c","province":"520000","licenseNumber":"15201201911085899","practiceStatus":"01","id":"190515HT1GSW2BXP","address":"贵阳市南明区花果园中央商务区4栋1单元2533号","business":[],"justiceBureauId":"38719bb7a917441a9b787de63da114c7","photo":"201228F88815BY14","publicStatus":true,"telephone":"18085809693","inhouseIdentity":"聘用专职律师","qualificationCertificateNumber":"A20165203300359","firstPracticeDate":1554220800000,"practiceType":"01","lawyerTeamFlag":-1,"name":"袁先利","lawfirmName":"贵州佰益律师事务所"}],"funcName":"page","firstPage":true,"maxResults":9,"pageNo":1,"notCount":false,"disabled":false,"first":1}
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
         * count : 5
         * firstResult : 0
         * pageSize : 9
         * resultData : [{"birthday":273859200000,"education":"de3f058bc9844263995d59631eb3db9a","lawfirm":"520102010103010001","gender":"0f33f0f8cdaf48d0b0cd9522756db346","city":"520100","nation":"add2e15654b24079aab1579794f93a46","lawfirmAddress":"贵州省贵阳市南明区贵州省贵阳市南明区花果园中央商务区F4栋","county":"520102","lawyerTitle":"aba9bae5db4f4fb88d470bad27bd4e82","justiceBureauName":"南明区司法局","lawfirmTelephone":"0851-85954445","isDeleted":0,"nationLanguage":"16d04df9cbd445d49c0e8ab6d2c2f29c","post":"a93ff3557aff45a2a13f0576d370d50c","province":"520000","licenseNumber":"15201201110910757","practiceStatus":"01","id":"5201020101020100020084","email":"359120437@qq.com","address":"贵阳市白云区金园路69号","business":[],"justiceBureauId":"38719bb7a917441a9b787de63da114c7","photo":"201228FD2B5HF140","publicStatus":true,"telephone":"18608509621","inhouseIdentity":"聘用专职律师","qualificationCertificateNumber":"A20085201133377","firstPracticeDate":1294502400000,"practiceType":"01","lawyerTeamFlag":-1,"name":"戴斌","lawfirmName":"贵州佰益律师事务所"},{"birthday":147024000000,"education":"de3f058bc9844263995d59631eb3db9a","lawfirm":"520102010103010001","gender":"0f33f0f8cdaf48d0b0cd9522756db346","city":"520100","nation":"add2e15654b24079aab1579794f93a46","lawfirmAddress":"贵州省贵阳市南明区贵州省贵阳市南明区花果园中央商务区F4栋","county":"520102","lawyerTitle":"aba9bae5db4f4fb88d470bad27bd4e82","justiceBureauName":"南明区司法局","lawfirmTelephone":"0851-85954445","isDeleted":0,"nationLanguage":"16d04df9cbd445d49c0e8ab6d2c2f29c","post":"a93ff3557aff45a2a13f0576d370d50c","province":"520000","politic":"1c624e8f217d459fa63e54fbdbfb15c3","licenseNumber":"15201200910147755","practiceStatus":"01","id":"5201020101020100020085","email":"1121009546@qq.com","address":"贵州省贵阳市南明区","business":[],"justiceBureauId":"38719bb7a917441a9b787de63da114c7","photo":"2012250YRNTDR77C","publicStatus":true,"telephone":"13639125982","inhouseIdentity":"负责人","qualificationCertificateNumber":"A20065201140041","firstPracticeDate":1231430400000,"practiceType":"01","lawyerTeamFlag":-1,"name":"胡勇","lawfirmName":"贵州佰益律师事务所"},{"birthday":815673600000,"education":"de3f058bc9844263995d59631eb3db9a","lawfirm":"520102010103010001","gender":"0f33f0f8cdaf48d0b0cd9522756db346","city":"520100","nation":"add2e15654b24079aab1579794f93a46","lawfirmAddress":"贵州省贵阳市南明区贵州省贵阳市南明区花果园中央商务区F4栋","county":"520102","lawyerTitle":"aba9bae5db4f4fb88d470bad27bd4e82","justiceBureauName":"南明区司法局","lawfirmTelephone":"0851-85954445","isDeleted":0,"nationLanguage":"16d04df9cbd445d49c0e8ab6d2c2f29c","post":"a93ff3557aff45a2a13f0576d370d50c","province":"520000","licenseNumber":"15201202010187254","practiceStatus":"01","id":"200515HRKTPMBA14","address":"贵州省贵阳市南明区太慈桥国际城","business":[],"justiceBureauId":"38719bb7a917441a9b787de63da114c7","photo":"201228F714MT0YCH","publicStatus":true,"telephone":"13120567560","inhouseIdentity":"聘用专职律师","qualificationCertificateNumber":"A20175201020859","firstPracticeDate":1589385600000,"practiceType":"01","lawyerTeamFlag":-1,"name":"罗新","lawfirmName":"贵州佰益律师事务所"},{"birthday":747331200000,"lawfirm":"520102010103010001","gender":"0f33f0f8cdaf48d0b0cd9522756db346","city":"520100","nation":"f2a88916be994159af6708470728ae7b","lawfirmAddress":"贵州省贵阳市南明区贵州省贵阳市南明区花果园中央商务区F4栋","county":"520102","lawyerTitle":"aba9bae5db4f4fb88d470bad27bd4e82","justiceBureauName":"南明区司法局","lawfirmTelephone":"0851-85954445","isDeleted":0,"nationLanguage":"16d04df9cbd445d49c0e8ab6d2c2f29c","post":"a93ff3557aff45a2a13f0576d370d50c","province":"520000","politic":"1c624e8f217d459fa63e54fbdbfb15c3","licenseNumber":"15201201710275713","practiceStatus":"01","id":"5201020101020100020847","email":"2549313545@qq.com","address":"贵阳市南明区花果园中央商务区4栋一单元25层33号","business":[],"justiceBureauId":"38719bb7a917441a9b787de63da114c7","photo":"2012250SHTP4BFK4","publicStatus":true,"telephone":"18798607318","inhouseIdentity":"聘用专职律师","qualificationCertificateNumber":"B20155226330003","firstPracticeDate":1501430400000,"practiceType":"01","lawyerTeamFlag":-1,"name":"姚红光","lawfirmName":"贵州佰益律师事务所"},{"birthday":553273200000,"education":"de3f058bc9844263995d59631eb3db9a","lawfirm":"520102010103010001","gender":"e10d702b89d849e789039de65cd268cd","city":"520100","nation":"add2e15654b24079aab1579794f93a46","lawfirmAddress":"贵州省贵阳市南明区贵州省贵阳市南明区花果园中央商务区F4栋","county":"520102","lawyerTitle":"aba9bae5db4f4fb88d470bad27bd4e82","justiceBureauName":"南明区司法局","lawfirmTelephone":"0851-85954445","isDeleted":0,"nationLanguage":"16d04df9cbd445d49c0e8ab6d2c2f29c","post":"a93ff3557aff45a2a13f0576d370d50c","province":"520000","licenseNumber":"15201201911085899","practiceStatus":"01","id":"190515HT1GSW2BXP","address":"贵阳市南明区花果园中央商务区4栋1单元2533号","business":[],"justiceBureauId":"38719bb7a917441a9b787de63da114c7","photo":"201228F88815BY14","publicStatus":true,"telephone":"18085809693","inhouseIdentity":"聘用专职律师","qualificationCertificateNumber":"A20165203300359","firstPracticeDate":1554220800000,"practiceType":"01","lawyerTeamFlag":-1,"name":"袁先利","lawfirmName":"贵州佰益律师事务所"}]
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
             * birthday : 273859200000
             * education : de3f058bc9844263995d59631eb3db9a
             * lawfirm : 520102010103010001
             * gender : 0f33f0f8cdaf48d0b0cd9522756db346
             * city : 520100
             * nation : add2e15654b24079aab1579794f93a46
             * lawfirmAddress : 贵州省贵阳市南明区贵州省贵阳市南明区花果园中央商务区F4栋
             * county : 520102
             * lawyerTitle : aba9bae5db4f4fb88d470bad27bd4e82
             * justiceBureauName : 南明区司法局
             * lawfirmTelephone : 0851-85954445
             * isDeleted : 0
             * nationLanguage : 16d04df9cbd445d49c0e8ab6d2c2f29c
             * post : a93ff3557aff45a2a13f0576d370d50c
             * province : 520000
             * licenseNumber : 15201201110910757
             * practiceStatus : 01
             * id : 5201020101020100020084
             * email : 359120437@qq.com
             * address : 贵阳市白云区金园路69号
             * business : []
             * justiceBureauId : 38719bb7a917441a9b787de63da114c7
             * photo : 201228FD2B5HF140
             * publicStatus : true
             * telephone : 18608509621
             * inhouseIdentity : 聘用专职律师
             * qualificationCertificateNumber : A20085201133377
             * firstPracticeDate : 1294502400000
             * practiceType : 01
             * lawyerTeamFlag : -1
             * name : 戴斌
             * lawfirmName : 贵州佰益律师事务所
             * politic : 1c624e8f217d459fa63e54fbdbfb15c3
             */

            @JsonProperty("birthday")
            private Long birthday;
            @JsonProperty("education")
            private String education;
            @JsonProperty("lawfirm")
            private String lawfirm;
            @JsonProperty("gender")
            private String gender;
            @JsonProperty("city")
            private String city;
            @JsonProperty("nation")
            private String nation;
            @JsonProperty("lawfirmAddress")
            private String lawfirmAddress;
            @JsonProperty("county")
            private String county;
            @JsonProperty("lawyerTitle")
            private String lawyerTitle;
            @JsonProperty("justiceBureauName")
            private String justiceBureauName;
            @JsonProperty("lawfirmTelephone")
            private String lawfirmTelephone;
            @JsonProperty("isDeleted")
            private Integer isDeleted;
            @JsonProperty("nationLanguage")
            private String nationLanguage;
            @JsonProperty("post")
            private String post;
            @JsonProperty("province")
            private String province;
            @JsonProperty("licenseNumber")
            private String licenseNumber;
            @JsonProperty("practiceStatus")
            private String practiceStatus;
            @JsonProperty("id")
            private String id;
            @JsonProperty("email")
            private String email;
            @JsonProperty("address")
            private String address;
            @JsonProperty("business")
            private List<?> business;
            @JsonProperty("justiceBureauId")
            private String justiceBureauId;
            @JsonProperty("photo")
            private String photo;
            @JsonProperty("publicStatus")
            private Boolean publicStatus;
            @JsonProperty("telephone")
            private String telephone;
            @JsonProperty("inhouseIdentity")
            private String inhouseIdentity;
            @JsonProperty("qualificationCertificateNumber")
            private String qualificationCertificateNumber;
            @JsonProperty("firstPracticeDate")
            private Long firstPracticeDate;
            @JsonProperty("practiceType")
            private String practiceType;
            @JsonProperty("lawyerTeamFlag")
            private Integer lawyerTeamFlag;
            @JsonProperty("name")
            private String name;
            @JsonProperty("lawfirmName")
            private String lawfirmName;
            @JsonProperty("politic")
            private String politic;
        }
    }
}
