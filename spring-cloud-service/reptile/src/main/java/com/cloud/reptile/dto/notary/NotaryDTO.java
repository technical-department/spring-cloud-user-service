package com.cloud.reptile.dto.notary;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 项目名称：spring-cloud-service
 * 类 名 称：Notary
 * 类 描 述：TODO
 * 创建时间：2021/2/26 下午10:50
 * 创 建 人：chenyouhong
 */
@NoArgsConstructor
@Data
public class NotaryDTO {


    /**
     * code : 1
     * description : null
     * secretKey : null
     * result : [{"orgName":"贵阳市国盛公证处","gender":"e10d702b89d849e789039de65cd268cd","isDeleted":0,"name":"薛艳","licenseNumber":"124011219920004","telephone":"0851-85802217","id":"200529B4TDWYA98H","orgId":"200519C2W0K8XNMW"},{"orgName":"贵阳市国盛公证处","gender":"e10d702b89d849e789039de65cd268cd","isDeleted":0,"name":"向琳","licenseNumber":"124011220110235","telephone":"0851-85872996","id":"200529B4TFR59F3C","orgId":"200519C2W0K8XNMW"},{"orgName":"贵阳市国盛公证处","gender":"0f33f0f8cdaf48d0b0cd9522756db346","isDeleted":0,"name":"刘建","licenseNumber":"124011120140313","telephone":"0851-85872996","id":"200529B4TFSM7XAW","orgId":"200519C2W0K8XNMW"},{"orgName":"贵阳市国盛公证处","gender":"e10d702b89d849e789039de65cd268cd","isDeleted":0,"name":"谢丽霞","licenseNumber":"124011220120267","telephone":"0851-85872996","id":"200529B4TFW368M8","orgId":"200519C2W0K8XNMW"},{"orgName":"贵阳市国盛公证处","gender":"0f33f0f8cdaf48d0b0cd9522756db346","isDeleted":0,"name":"杨林","licenseNumber":"124011120150337","telephone":"0851-85872996","id":"200529B4TFXCR4ZC","orgId":"200519C2W0K8XNMW"},{"orgName":"贵阳市国盛公证处","gender":"e10d702b89d849e789039de65cd268cd","isDeleted":0,"name":"张又山","licenseNumber":"124011220150335","telephone":"0851-85872996","id":"200529B4TFYS818H","orgId":"200519C2W0K8XNMW"},{"orgName":"贵阳市国盛公证处","gender":"0f33f0f8cdaf48d0b0cd9522756db346","isDeleted":0,"name":"陈治","licenseNumber":"112011120150336","telephone":"0851-85872996","id":"200529B4TG0AKZF8","orgId":"200519C2W0K8XNMW"},{"orgName":"贵阳市国盛公证处","gender":"0f33f0f8cdaf48d0b0cd9522756db346","isDeleted":0,"name":"李世衡","licenseNumber":"124011119920003","telephone":"0851-85872996","id":"200529B4TG1THARP","orgId":"200519C2W0K8XNMW"},{"orgName":"贵阳市国盛公证处","gender":"e10d702b89d849e789039de65cd268cd","isDeleted":0,"name":"王红敏","licenseNumber":"124011220180439","telephone":"0851-85802207","id":"200529B4TG38FS14","orgId":"200519C2W0K8XNMW"}]
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
    private List<ResultDTO> result;
    @JsonProperty("exception")
    private Object exception;
    @JsonProperty("success")
    private Boolean success;

    @NoArgsConstructor
    @Data
    public static class ResultDTO {
        /**
         * orgName : 贵阳市国盛公证处
         * gender : e10d702b89d849e789039de65cd268cd
         * isDeleted : 0
         * name : 薛艳
         * licenseNumber : 124011219920004
         * telephone : 0851-85802217
         * id : 200529B4TDWYA98H
         * orgId : 200519C2W0K8XNMW
         */

        @JsonProperty("orgName")
        private String orgName;
        @JsonProperty("gender")
        private String gender;
        @JsonProperty("isDeleted")
        private Integer isDeleted;
        @JsonProperty("name")
        private String name;
        @JsonProperty("licenseNumber")
        private String licenseNumber;
        @JsonProperty("telephone")
        private String telephone;
        @JsonProperty("id")
        private String id;
        @JsonProperty("orgId")
        private String orgId;
    }
}
