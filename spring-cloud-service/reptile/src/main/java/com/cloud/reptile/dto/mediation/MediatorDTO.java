package com.cloud.reptile.dto.mediation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 项目名称：spring-cloud-service
 * 类 名 称：MediatorDTO
 * 类 描 述：TODO
 * 创建时间：2021/2/27 下午2:18
 * 创 建 人：chenyouhong
 */
@NoArgsConstructor
@Data
public class MediatorDTO {


    /**
     * code : 1
     * description : null
     * secretKey : null
     * result : {"next":1,"last":1,"lastPage":true,"totalPage":1,"prev":1,"count":7,"firstResult":0,"pageSize":20,"resultData":[{"orgName":"沙冲社区凤凰湾居委会人民调解委员会","isDeleted":0,"name":"吴惠楠","id":"995589DA363818549B121EB27E1B92EE"},{"education":"5b33d0a7bc4242f3a820ea4426d5fc04","orgName":"沙冲社区凤凰湾居委会人民调解委员会","gender":"e10d702b89d849e789039de65cd268cd","isDeleted":0,"name":"吴惠楠","id":"FA17971640AA4FA6078AF5AD5BF9AF01"},{"orgName":"沙冲社区凤凰湾居委会人民调解委员会","isDeleted":0,"name":"吴惠楠","id":"796E8C35A3132235AE7433C54CCB8980"},{"education":"5b33d0a7bc4242f3a820ea4426d5fc04","orgName":"沙冲社区凤凰湾居委会人民调解委员会","gender":"e10d702b89d849e789039de65cd268cd","isDeleted":0,"name":"熊樱","id":"76E77B41D890D61C9FDEB0ADC7A7056E"},{"orgName":"沙冲社区凤凰湾居委会人民调解委员会","isDeleted":0,"name":"吴惠楠","id":"9D880207625BBA78088893DE974C2D52"},{"education":"b125b113cdd84311805de287166b3b1b","orgName":"沙冲社区凤凰湾居委会人民调解委员会","gender":"e10d702b89d849e789039de65cd268cd","isDeleted":0,"name":"龙大雪","id":"B98B5C5F21EF453601949D43B059419D"},{"orgName":"沙冲社区凤凰湾居委会人民调解委员会","isDeleted":0,"name":"沙冲社区凤凰湾居委会人民调解委员会","id":"1ED7AC6C5F33F840A0741378A1F2755A"}],"funcName":"page","firstPage":true,"maxResults":20,"pageNo":1,"notCount":false,"disabled":false,"first":1}
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
         * count : 7
         * firstResult : 0
         * pageSize : 20
         * resultData : [{"orgName":"沙冲社区凤凰湾居委会人民调解委员会","isDeleted":0,"name":"吴惠楠","id":"995589DA363818549B121EB27E1B92EE"},{"education":"5b33d0a7bc4242f3a820ea4426d5fc04","orgName":"沙冲社区凤凰湾居委会人民调解委员会","gender":"e10d702b89d849e789039de65cd268cd","isDeleted":0,"name":"吴惠楠","id":"FA17971640AA4FA6078AF5AD5BF9AF01"},{"orgName":"沙冲社区凤凰湾居委会人民调解委员会","isDeleted":0,"name":"吴惠楠","id":"796E8C35A3132235AE7433C54CCB8980"},{"education":"5b33d0a7bc4242f3a820ea4426d5fc04","orgName":"沙冲社区凤凰湾居委会人民调解委员会","gender":"e10d702b89d849e789039de65cd268cd","isDeleted":0,"name":"熊樱","id":"76E77B41D890D61C9FDEB0ADC7A7056E"},{"orgName":"沙冲社区凤凰湾居委会人民调解委员会","isDeleted":0,"name":"吴惠楠","id":"9D880207625BBA78088893DE974C2D52"},{"education":"b125b113cdd84311805de287166b3b1b","orgName":"沙冲社区凤凰湾居委会人民调解委员会","gender":"e10d702b89d849e789039de65cd268cd","isDeleted":0,"name":"龙大雪","id":"B98B5C5F21EF453601949D43B059419D"},{"orgName":"沙冲社区凤凰湾居委会人民调解委员会","isDeleted":0,"name":"沙冲社区凤凰湾居委会人民调解委员会","id":"1ED7AC6C5F33F840A0741378A1F2755A"}]
         * funcName : page
         * firstPage : true
         * maxResults : 20
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
             * orgName : 沙冲社区凤凰湾居委会人民调解委员会
             * isDeleted : 0
             * name : 吴惠楠
             * id : 995589DA363818549B121EB27E1B92EE
             * education : 5b33d0a7bc4242f3a820ea4426d5fc04
             * gender : e10d702b89d849e789039de65cd268cd
             */

            @JsonProperty("orgName")
            private String orgName;
            @JsonProperty("isDeleted")
            private Integer isDeleted;
            @JsonProperty("name")
            private String name;
            @JsonProperty("id")
            private String id;
            @JsonProperty("education")
            private String education;
            @JsonProperty("gender")
            private String gender;
        }
    }
}


