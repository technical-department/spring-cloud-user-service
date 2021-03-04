package com.cloud.reptile.dto.legal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 项目名称：spring-cloud-service
 * 类 名 称：LegalAidAgencyDTO
 * 类 描 述：TODO
 * 创建时间：2021/2/26 下午5:47
 * 创 建 人：chenyouhong
 */
@NoArgsConstructor
@Data
public class LegalAidAgencyDTO {


    /**
     * code : 1
     * description : null
     * secretKey : null
     * result : [{"address":"清镇市百花路14号清镇市司法局","isDeleted":0,"province":"520000","city":"520100","county":"520181","name":"清镇市法律援助中心","admLevel":"03","telephone":"0851-82526148","id":"5c013742bb404ee9b4ae159036156713","axis":"106.712761,26.579543","completeAddress":"清镇市百花路14号清镇市司法局"},{"address":"龙场镇河滨路13号","isDeleted":0,"province":"520000","city":"520100","county":"520123","name":"修文县法律援助中心","admLevel":"03","telephone":"0851-82371148","id":"a31a80eb4e864d7ab28eae025ec85363","completeAddress":"贵州省贵阳市修文县龙场镇河滨路13号"},{"address":"福寿路息烽县司法局","isDeleted":0,"province":"520000","city":"520100","county":"520122","name":"息烽县法律援助中心","admLevel":"03","telephone":"0851-87727148","id":"e6e80305bb8d4cd9bd385b023e4cece0","completeAddress":"贵州省贵阳市息烽县福寿路息烽县司法局"},{"address":"城关镇育英路2号","isDeleted":0,"province":"520000","city":"520100","county":"520121","name":"开阳县法律援助中心","admLevel":"03","telephone":"0851-87229090","id":"641a49e7371e4329a0cd6c215b628e95","completeAddress":"贵州省贵阳市开阳县城关镇育英路2号"},{"address":"贵州省贵阳市观山湖区金融城MAX-B座5楼3号","isDeleted":0,"province":"520000","city":"520100","county":"520115","name":"贵州省法律援助中心","admLevel":"01","telephone":"0851-84731496","id":"53b8ebce391441778a2c363119fde766","completeAddress":"贵州省贵阳市观山湖区贵州省贵阳市观山湖区金融城MAX-B座5楼3号"},{"address":"贵阳市观山湖区林城东路大关城市花园3栋负一层","isDeleted":0,"province":"520000","city":"520100","county":"520115","name":"观山湖区法律援助中心","admLevel":"03","telephone":"0851-84124148","id":"665ba7b9e15541e88210b7db94d2da9a","axis":"106.668591,26.640604","completeAddress":"贵州省贵阳市贵阳市观山湖区林城东路大关城市花园3栋负一层"},{"address":"贵阳市白云区七一路行政中心二期白云区司法局一楼","isDeleted":0,"province":"520000","city":"520100","county":"520113","name":"白云区法律援助中心","admLevel":"03","telephone":"0851-84600148","id":"e792835845d4421ca983d8472d7f2fab","axis":"106.625022,26.683602","completeAddress":"贵阳市白云区七一路行政中心二期白云区司法局一楼"},{"address":"行政中心航天大道17号","isDeleted":0,"province":"520000","city":"520100","county":"520112","name":"乌当区法律援助中心","admLevel":"03","telephone":"0851-86840148","id":"2f0b54b0654c46b19f5b5a253cfa85fe","axis":"106.712761,26.579543","completeAddress":"贵州省贵阳市乌当区行政中心航天大道17号"},{"address":"花溪区明珠大道洛平新城16栋公共法律服务中心二楼","isDeleted":0,"province":"520000","city":"520100","county":"520111","name":"花溪区法律援助中心","admLevel":"03","telephone":"0851-83625148","id":"71d433147ead4d1a8b23871e2d68d7fe","completeAddress":"花溪区明珠大道洛平新城16栋公共法律服务中心二楼"},{"address":"宝山北路217号","isDeleted":0,"province":"520000","city":"520100","county":"520103","name":"云岩区法律援助中心","admLevel":"03","telephone":"0851-86619148","id":"b4bbe9a897e44cfcbc752e98d619768f","completeAddress":"贵州省贵阳市云岩区宝山北路217号"},{"address":"瑞金北路128号胜鹏大厦六楼","isDeleted":0,"province":"520000","city":"520100","county":"520103","name":"贵阳市法律援助中心","admLevel":"02","telephone":"0851-12348","id":"d404f7b3790046e7b13afcd499d0d696","axis":"106.712761,26.579543","completeAddress":"贵州省贵阳市云岩区瑞金北路128号胜鹏大厦六楼"},{"address":"油榨街青年路127号","isDeleted":0,"province":"520000","city":"520100","county":"520102","name":"南明区法律援助中心","admLevel":"03","telephone":"0851-85509808","id":"f29d858ee4d946ce87f75ffe01fc9ff1","completeAddress":"贵州省贵阳市南明区油榨街青年路127号"},{"address":"贵安新区","isDeleted":0,"province":"520000","city":"520100","county":"1b6405e7f50d472f884539d5458afdb7","name":"贵安新区法律援助中心","admLevel":"03","telephone":"0851-88904568","id":"232538f1783b429c856c69d31447b88f","axis":"106.500074,26.443709","completeAddress":"贵州省贵阳市贵安新区本级贵安新区"}]
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
         * address : 清镇市百花路14号清镇市司法局
         * isDeleted : 0
         * province : 520000
         * city : 520100
         * county : 520181
         * name : 清镇市法律援助中心
         * admLevel : 03
         * telephone : 0851-82526148
         * id : 5c013742bb404ee9b4ae159036156713
         * axis : 106.712761,26.579543
         * completeAddress : 清镇市百花路14号清镇市司法局
         */

        @JsonProperty("address")
        private String address;
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
        @JsonProperty("admLevel")
        private String admLevel;
        @JsonProperty("telephone")
        private String telephone;
        @JsonProperty("id")
        private String id;
        @JsonProperty("axis")
        private String axis;

        /**
         * 经度
         */
        private Double longitude;

        /**
         * 纬度
         */
        private Double latitude;

        @JsonProperty("completeAddress")
        private String completeAddress;
    }
}
