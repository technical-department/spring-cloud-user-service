package com.cloud.reptile.dto.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 项目名称：spring-cloud-service
 * 类 名 称：IdentifierDTO
 * 类 描 述：TODO
 * 创建时间：2021/2/27 上午12:04
 * 创 建 人：chenyouhong
 */
@NoArgsConstructor
@Data
public class IdentifierDTO {

    /**
     * code : 1
     * description : null
     * secretKey : null
     * result : [{"gender":"e10d702b89d849e789039de65cd268cd","isDeleted":0,"licenseStartDate":1481472000000,"name":"薛颖","licenseNumber":"520011019002","telephone":"0851-85112047","id":"0c840c67-9f9b-414d-bc10-f79ab9deac88","licenseEndDate":1639238400000,"orgId":"11520000429202190H","certificateType":"法医临床鉴定"},{"gender":"0f33f0f8cdaf48d0b0cd9522756db346","isDeleted":0,"licenseStartDate":1601481600000,"name":"牟苇","licenseNumber":"520005001002","telephone":"0851-85112047","id":"181b5c10-0648-4599-b2ab-f97e8142a8bb","licenseEndDate":1759248000000,"orgId":"11520000429202190H","certificateType":"法医临床鉴定"},{"gender":"0f33f0f8cdaf48d0b0cd9522756db346","isDeleted":0,"licenseStartDate":1601481600000,"name":"邱建明","licenseNumber":"520005001011","telephone":"0851-85112047","id":"208bc218-1e6e-4f9d-a230-db68f0f5b5ce","licenseEndDate":1759248000000,"orgId":"11520000429202190H","certificateType":"法医临床鉴定"},{"gender":"e10d702b89d849e789039de65cd268cd","isDeleted":0,"licenseStartDate":1427472000000,"name":"徐玲","licenseNumber":"520005017035","telephone":"0851-85112047","id":"5502d83a-02d4-448c-ab7b-29547efc062d","licenseEndDate":1616860800000,"orgId":"11520000429202190H","certificateType":"法医临床鉴定"},{"gender":"0f33f0f8cdaf48d0b0cd9522756db346","isDeleted":0,"licenseStartDate":1443628800000,"name":"孙炜","licenseNumber":"520005001013","telephone":"0851-85112047","id":"57ac98ea-3a1e-4790-983f-6c6d05c1f9ae","licenseEndDate":1601481600000,"orgId":"11520000429202190H","certificateType":"法医临床鉴定"},{"gender":"e10d702b89d849e789039de65cd268cd","isDeleted":0,"licenseStartDate":1481472000000,"name":"赵海霞","licenseNumber":"520011019003","telephone":"0851-85112047","id":"5c61c26b-0347-4001-b672-a5fdb79c734d","licenseEndDate":1639238400000,"orgId":"11520000429202190H","certificateType":"法医临床鉴定"},{"gender":"0f33f0f8cdaf48d0b0cd9522756db346","isDeleted":0,"licenseStartDate":1601481600000,"name":"张中元","licenseNumber":"520005001009","telephone":"0851-85112047","id":"6d74fe55-fcb6-4922-8c5b-46bfbee624db","licenseEndDate":1759248000000,"orgId":"11520000429202190H","certificateType":"法医临床鉴定"},{"gender":"0f33f0f8cdaf48d0b0cd9522756db346","isDeleted":0,"licenseStartDate":1459094400000,"name":"赵奕","licenseNumber":"520005017032","telephone":"0851-85112047","id":"70114046-6d12-42ab-bf46-d8a7929b7005","licenseEndDate":1616860800000,"orgId":"11520000429202190H","certificateType":"法医临床鉴定"},{"gender":"0f33f0f8cdaf48d0b0cd9522756db346","isDeleted":0,"licenseStartDate":1601481600000,"name":"安利民","licenseNumber":"520005001010","telephone":"0851-85112047","id":"86b5d7c8-066d-4db7-ad3d-a79cde4abf79","licenseEndDate":1759248000000,"orgId":"11520000429202190H","certificateType":"法医临床鉴定"},{"gender":"e10d702b89d849e789039de65cd268cd","isDeleted":0,"licenseStartDate":1459094400000,"name":"余维","licenseNumber":"520005017031","telephone":"0851-85112047","id":"916afce5-2c37-46bb-a4f0-95428d7327cc","licenseEndDate":1616860800000,"orgId":"11520000429202190H","certificateType":"法医临床鉴定"},{"gender":"0f33f0f8cdaf48d0b0cd9522756db346","isDeleted":0,"licenseStartDate":1481472000000,"name":"杨松青昀","licenseNumber":"520011019005","telephone":"0851-85112047","id":"a0d0f538-4324-4c0e-a175-411c6b34724f","licenseEndDate":1639238400000,"orgId":"11520000429202190H","certificateType":"法医临床鉴定"},{"gender":"e10d702b89d849e789039de65cd268cd","isDeleted":0,"licenseStartDate":1481472000000,"name":"雷玲","licenseNumber":"520011019004","telephone":"0851-85112047","id":"b2db79c9-e4f4-4168-af9c-6037b1290c7a","licenseEndDate":1639238400000,"orgId":"11520000429202190H","certificateType":"法医临床鉴定"},{"gender":"0f33f0f8cdaf48d0b0cd9522756db346","isDeleted":0,"licenseStartDate":1459094400000,"name":"雷志学","licenseNumber":"520005017034","telephone":"0851-85112047","id":"c2557127-14b7-4a9b-a52c-7b9e70d3a787","licenseEndDate":1616860800000,"orgId":"11520000429202190H","certificateType":"法医临床鉴定"},{"gender":"e10d702b89d849e789039de65cd268cd","isDeleted":0,"licenseStartDate":1527436800000,"name":"耿丽环","licenseNumber":"520013019001","telephone":"0851-85112047","id":"c809bf36-6fa1-4742-b2bd-691b0ec54f77","licenseEndDate":1685203200000,"orgId":"11520000429202190H","certificateType":"法医临床鉴定"},{"gender":"0f33f0f8cdaf48d0b0cd9522756db346","isDeleted":0,"licenseStartDate":1459094400000,"name":"杨先兵","licenseNumber":"520005017030","telephone":"0851-85112047","id":"d5e27472-43f5-4add-b23a-79f7744a38cd","licenseEndDate":1616860800000,"orgId":"11520000429202190H","certificateType":"法医临床鉴定"},{"gender":"e10d702b89d849e789039de65cd268cd","isDeleted":0,"licenseStartDate":1443628800000,"name":"吴敏","licenseNumber":"520005001006","telephone":"0851-85112047","id":"d8589bf0-2e61-4954-95d1-5b091fdb4a4b","licenseEndDate":1601481600000,"orgId":"11520000429202190H","certificateType":"法医临床鉴定"},{"gender":"0f33f0f8cdaf48d0b0cd9522756db346","isDeleted":0,"licenseStartDate":1481472000000,"name":"贺正友","licenseNumber":"520011019001","telephone":"0851-85112047","id":"e3d04e1a-6626-4f6b-b09f-1f9c57f6561a","licenseEndDate":1639238400000,"orgId":"11520000429202190H","certificateType":"法医临床鉴定"},{"gender":"e10d702b89d849e789039de65cd268cd","isDeleted":0,"licenseStartDate":1459094400000,"name":"杨珊","licenseNumber":"520005017033","telephone":"0851-85112047","id":"fc44959e-6afa-48a8-be88-c74bdc67b074","licenseEndDate":1616860800000,"orgId":"11520000429202190H","certificateType":"法医临床鉴定"}]
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
         * gender : e10d702b89d849e789039de65cd268cd
         * isDeleted : 0
         * licenseStartDate : 1481472000000
         * name : 薛颖
         * licenseNumber : 520011019002
         * telephone : 0851-85112047
         * id : 0c840c67-9f9b-414d-bc10-f79ab9deac88
         * licenseEndDate : 1639238400000
         * orgId : 11520000429202190H
         * certificateType : 法医临床鉴定
         */

        @JsonProperty("gender")
        private String gender;
        @JsonProperty("isDeleted")
        private Integer isDeleted;
        @JsonProperty("licenseStartDate")
        private Long licenseStartDate;
        @JsonProperty("name")
        private String name;
        @JsonProperty("licenseNumber")
        private String licenseNumber;
        @JsonProperty("telephone")
        private String telephone;
        @JsonProperty("id")
        private String id;
        @JsonProperty("licenseEndDate")
        private Long licenseEndDate;
        @JsonProperty("orgId")
        private String orgId;
        @JsonProperty("certificateType")
        private String certificateType;
    }

}
