package com.cloud.reptile.dto.notary.organization;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 项目名称：spring-cloud-service
 * 类 名 称：NotaryOrganizationDTO
 * 类 描 述：TODO
 * 创建时间：2021/2/26 下午10:52
 * 创 建 人：chenyouhong
 */
@NoArgsConstructor
@Data
public class NotaryOrganizationDTO {
    /**
     * code : 1
     * description : null
     * secretKey : null
     * result : {"next":1,"last":1,"lastPage":true,"totalPage":1,"prev":1,"count":12,"firstResult":0,"pageSize":100,"resultData":[{"cityName":"贵阳市","isDeleted":0,"province":"520000","city":"520100","county":"520115","name":"贵阳市国信公证处","licenseNumber":"32520000MD5016009P","telephone":"0851\u201485872405","id":"200519C2W0K5F4PH","provinceName":"贵州省","countyName":"观山湖区"},{"address":"贵州省贵阳市云岩区中华北路289号6-7楼","city":"520100","county":"520101","telephone":"0851----85802217","axis":"106.712761,26.579543","serviceTime":"上午9：00--12：00，下午1：30--5：30，节假日可预约办证。","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵阳市国盛公证处","licenseNumber":"32520000MD501676XC","serviceScope":"99e673e4aabb49519d25ebc0289a9e75,c12b2e462a5348f2a3588f2eaea938c3,a0c3a0c33d7146b094ed49298f835727,26c1f15f5ce846b2bcba44cbecfeacc1,f742b707fc5d480591437f7a84696fc9,0485291fd32b4a16a463f47e5991756b,d901842add2e4d78829235dacee11609,195f7d261dc84ab48fa0048ea1ab6fbe,d245e0b56e1740efbb6ccd202016523c,bfd53e41f9cf40c485502ddaaa596983,34358e50e5ea4172818e6d391f1058b2,80fbf0eaf118459dbc1a291fbe1a9a5b,c537e68b518146379c9f191374b5004e,fff25717ecba4a21a1d0b3fe159efaf7,17bcdff8034f429eb442929d329d9bd5,76799ff8959945c78be2913ef5f1cc83","id":"200519C2W0K8XNMW","provinceName":"贵州省","countyName":"市辖区"},{"address":"贵州省贵阳市宝山北路217号","city":"520100","county":"520103","telephone":"0851\u201486772145","axis":"106.71287328818867,26.579429895383186","serviceTime":"9:00-12:00；13:00-17:00","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵州省贵阳市立诚公证处","licenseNumber":"3252000MD5011267Y","serviceScope":"99e673e4aabb49519d25ebc0289a9e75,c12b2e462a5348f2a3588f2eaea938c3,a0c3a0c33d7146b094ed49298f835727,26c1f15f5ce846b2bcba44cbecfeacc1,f742b707fc5d480591437f7a84696fc9,0485291fd32b4a16a463f47e5991756b,d901842add2e4d78829235dacee11609,195f7d261dc84ab48fa0048ea1ab6fbe,d245e0b56e1740efbb6ccd202016523c,bfd53e41f9cf40c485502ddaaa596983,34358e50e5ea4172818e6d391f1058b2,80fbf0eaf118459dbc1a291fbe1a9a5b,c537e68b518146379c9f191374b5004e,fff25717ecba4a21a1d0b3fe159efaf7,17bcdff8034f429eb442929d329d9bd5,76799ff8959945c78be2913ef5f1cc83","id":"200519C2W0K8XNMX","provinceName":"贵州省","introduction":"贵州省责阳市立诚公证处(原名贵阳市云岩区公证处)成立于1984年，是云岩区司法局所属单位。历经30余年的发展，我处现在拥有一支高素质的公证人员队伍。其中，执业公证员4名、公证员助理18名、后勤行政人员8名。长期为我区轨道交通、1.5环、人民大道、棚户区改造、云岩区法院强制执行等工作提供了坚强的法律保障，为推进我区的经济、社会建设起到了不可替代的作用。历年来我处多次受到省厅、市局及区委区政府的好评。同时，也得到了社会的广泛认可和信赖，为我区经济建设、构建和谐社会作出了应有的贡献。2017年以来，按照省、市、区推进公证机构体制改革总体部署，经云岩区编制委员会办公室批复，通过新设立事业单位的方式，立诚公证处改制为云岩区司法局所属股级公益二类事业单位，并于2018年5月18日取得《事业单位法人证书》，逐步落实并完善各项便民服务举措，进一步加强公证标准化建设。立诚公证处贴近群众，以专业化家事法律服务为立足，开展各项公证及法律服务业务，业务范围如下：\n1、办理家事法律服务类公证业务，包括办理委托、声明、继承、赠与、财产约定、协议书等公证，根据申请人的申请和委托代为办理不动产转移、抵押等登记手续；\n2、办理权益保护类公证业务，例如保护知识产权、保护名誉权、肖像权等，包括相关的购买物品，保全现状，保全网页、电子邮件、手机短信、微信证据等保全证据公证；\n3、办理金融法律服务类公证业务，包括为金融机构办理经济同、办理赋情权文书制执行效力公证，代为送达催收函件等；\n4、办理辅助人民法院工作类公证业务，包括依据人民法院的委托参与诉前调解、代为调查取证、代为办理查封财产手续、代为送达法律文书、在人民法院强制执行工作中办理清点、封存物品等公证；\n5、办理提存类公证，包括钱款以及物品等的提存、商品交易货款监管等；\n6、办理抵押登记类公证业务，办理动产抵押登记、权利质押登根据申请人的申请和委托，代为办理抵押登记；\n7、提供公证法律咨询类服务、受聘担任法律顾问等；\n8、法律允许的其他非诉讼法律服务业务。\n\n贵州省贵阳市立诚公证处地址：贵阳市云岩区宝山北路217号(市药材公司内）\n业务咨询电话：0851-86829710\n办公室电话/传真：0851-86772145","countyName":"云岩区"},{"address":"贵阳市南明区中山西路77号华亿大厦25楼","city":"520100","county":"520102","telephone":"0851\u201485818716","serviceTime":"09:00-17:00","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵阳市衡律公证处","licenseNumber":"32520000MD5014978G","serviceScope":"99e673e4aabb49519d25ebc0289a9e75,c12b2e462a5348f2a3588f2eaea938c3,a0c3a0c33d7146b094ed49298f835727,26c1f15f5ce846b2bcba44cbecfeacc1,f742b707fc5d480591437f7a84696fc9,0485291fd32b4a16a463f47e5991756b,d901842add2e4d78829235dacee11609,195f7d261dc84ab48fa0048ea1ab6fbe,bfd53e41f9cf40c485502ddaaa596983,34358e50e5ea4172818e6d391f1058b2,80fbf0eaf118459dbc1a291fbe1a9a5b,17bcdff8034f429eb442929d329d9bd5","id":"200519C2W0KC96K4","provinceName":"贵州省","countyName":"南明区"},{"cityName":"贵阳市","isDeleted":0,"province":"520000","city":"520100","county":"520102","name":"贵阳市新天公证处","licenseNumber":"32520000MD50112594","serviceScope":"99e673e4aabb49519d25ebc0289a9e75","telephone":"0851\u201486402059","id":"200519C2W0KC96K5","provinceName":"贵州省","countyName":"南明区"},{"cityName":"贵阳市","isDeleted":0,"province":"520000","city":"520100","county":"520111","name":"贵阳市明珠公证处","licenseNumber":"32520000MD5011232C","telephone":"0851\u201483620231","id":"200519C2W0KGPRGC","provinceName":"贵州省","countyName":"花溪区"},{"cityName":"贵阳市","isDeleted":0,"province":"520000","city":"520100","county":"520113","name":"贵阳市南湖公证处","licenseNumber":"32520000429310300A","telephone":"0851\u201484833007","id":"200519C2W0KGPRGD","provinceName":"贵州省","countyName":"白云区"},{"cityName":"贵阳市","isDeleted":0,"province":"520000","city":"520100","county":"520115","name":"贵阳市诚信公证处","licenseNumber":"32520000K363497016","telephone":"0851\u201484813903","id":"200519C2W0KGPRGF","provinceName":"贵州省","countyName":"观山湖区"},{"cityName":"贵阳市","isDeleted":0,"province":"520000","city":"520100","county":"520181","name":"清镇市公证处","licenseNumber":"32520000MD50112407","telephone":"0851\u201482522158","id":"200519C2W0KN48DP","provinceName":"贵州省","countyName":"清镇市"},{"cityName":"贵阳市","isDeleted":0,"province":"520000","city":"520100","county":"520123","name":"修文县公证处","licenseNumber":"325200000097200639","telephone":"0851\u201482372559","id":"200519C2W0KN48DR","provinceName":"贵州省","countyName":"修文县"},{"cityName":"贵阳市","isDeleted":0,"province":"520000","city":"520100","county":"520121","name":"开阳县公证处","licenseNumber":"125201214299512201","telephone":"0851\u201487221135","id":"200519C2W0KSGTC0","provinceName":"贵州省","countyName":"开阳县"},{"cityName":"贵阳市","isDeleted":0,"province":"520000","city":"520100","county":"520122","name":"息烽县公证处","licenseNumber":"32520000009718334C","telephone":"0851\u201487721154","id":"200519C2W0KSGTC1","provinceName":"贵州省","countyName":"息烽县"}],"funcName":"page","firstPage":true,"maxResults":100,"pageNo":1,"notCount":false,"disabled":false,"first":1}
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
         * count : 12
         * firstResult : 0
         * pageSize : 100
         * resultData : [{"cityName":"贵阳市","isDeleted":0,"province":"520000","city":"520100","county":"520115","name":"贵阳市国信公证处","licenseNumber":"32520000MD5016009P","telephone":"0851\u201485872405","id":"200519C2W0K5F4PH","provinceName":"贵州省","countyName":"观山湖区"},{"address":"贵州省贵阳市云岩区中华北路289号6-7楼","city":"520100","county":"520101","telephone":"0851----85802217","axis":"106.712761,26.579543","serviceTime":"上午9：00--12：00，下午1：30--5：30，节假日可预约办证。","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵阳市国盛公证处","licenseNumber":"32520000MD501676XC","serviceScope":"99e673e4aabb49519d25ebc0289a9e75,c12b2e462a5348f2a3588f2eaea938c3,a0c3a0c33d7146b094ed49298f835727,26c1f15f5ce846b2bcba44cbecfeacc1,f742b707fc5d480591437f7a84696fc9,0485291fd32b4a16a463f47e5991756b,d901842add2e4d78829235dacee11609,195f7d261dc84ab48fa0048ea1ab6fbe,d245e0b56e1740efbb6ccd202016523c,bfd53e41f9cf40c485502ddaaa596983,34358e50e5ea4172818e6d391f1058b2,80fbf0eaf118459dbc1a291fbe1a9a5b,c537e68b518146379c9f191374b5004e,fff25717ecba4a21a1d0b3fe159efaf7,17bcdff8034f429eb442929d329d9bd5,76799ff8959945c78be2913ef5f1cc83","id":"200519C2W0K8XNMW","provinceName":"贵州省","countyName":"市辖区"},{"address":"贵州省贵阳市宝山北路217号","city":"520100","county":"520103","telephone":"0851\u201486772145","axis":"106.71287328818867,26.579429895383186","serviceTime":"9:00-12:00；13:00-17:00","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵州省贵阳市立诚公证处","licenseNumber":"3252000MD5011267Y","serviceScope":"99e673e4aabb49519d25ebc0289a9e75,c12b2e462a5348f2a3588f2eaea938c3,a0c3a0c33d7146b094ed49298f835727,26c1f15f5ce846b2bcba44cbecfeacc1,f742b707fc5d480591437f7a84696fc9,0485291fd32b4a16a463f47e5991756b,d901842add2e4d78829235dacee11609,195f7d261dc84ab48fa0048ea1ab6fbe,d245e0b56e1740efbb6ccd202016523c,bfd53e41f9cf40c485502ddaaa596983,34358e50e5ea4172818e6d391f1058b2,80fbf0eaf118459dbc1a291fbe1a9a5b,c537e68b518146379c9f191374b5004e,fff25717ecba4a21a1d0b3fe159efaf7,17bcdff8034f429eb442929d329d9bd5,76799ff8959945c78be2913ef5f1cc83","id":"200519C2W0K8XNMX","provinceName":"贵州省","introduction":"贵州省责阳市立诚公证处(原名贵阳市云岩区公证处)成立于1984年，是云岩区司法局所属单位。历经30余年的发展，我处现在拥有一支高素质的公证人员队伍。其中，执业公证员4名、公证员助理18名、后勤行政人员8名。长期为我区轨道交通、1.5环、人民大道、棚户区改造、云岩区法院强制执行等工作提供了坚强的法律保障，为推进我区的经济、社会建设起到了不可替代的作用。历年来我处多次受到省厅、市局及区委区政府的好评。同时，也得到了社会的广泛认可和信赖，为我区经济建设、构建和谐社会作出了应有的贡献。2017年以来，按照省、市、区推进公证机构体制改革总体部署，经云岩区编制委员会办公室批复，通过新设立事业单位的方式，立诚公证处改制为云岩区司法局所属股级公益二类事业单位，并于2018年5月18日取得《事业单位法人证书》，逐步落实并完善各项便民服务举措，进一步加强公证标准化建设。立诚公证处贴近群众，以专业化家事法律服务为立足，开展各项公证及法律服务业务，业务范围如下：\n1、办理家事法律服务类公证业务，包括办理委托、声明、继承、赠与、财产约定、协议书等公证，根据申请人的申请和委托代为办理不动产转移、抵押等登记手续；\n2、办理权益保护类公证业务，例如保护知识产权、保护名誉权、肖像权等，包括相关的购买物品，保全现状，保全网页、电子邮件、手机短信、微信证据等保全证据公证；\n3、办理金融法律服务类公证业务，包括为金融机构办理经济同、办理赋情权文书制执行效力公证，代为送达催收函件等；\n4、办理辅助人民法院工作类公证业务，包括依据人民法院的委托参与诉前调解、代为调查取证、代为办理查封财产手续、代为送达法律文书、在人民法院强制执行工作中办理清点、封存物品等公证；\n5、办理提存类公证，包括钱款以及物品等的提存、商品交易货款监管等；\n6、办理抵押登记类公证业务，办理动产抵押登记、权利质押登根据申请人的申请和委托，代为办理抵押登记；\n7、提供公证法律咨询类服务、受聘担任法律顾问等；\n8、法律允许的其他非诉讼法律服务业务。\n\n贵州省贵阳市立诚公证处地址：贵阳市云岩区宝山北路217号(市药材公司内）\n业务咨询电话：0851-86829710\n办公室电话/传真：0851-86772145","countyName":"云岩区"},{"address":"贵阳市南明区中山西路77号华亿大厦25楼","city":"520100","county":"520102","telephone":"0851\u201485818716","serviceTime":"09:00-17:00","cityName":"贵阳市","isDeleted":0,"province":"520000","name":"贵阳市衡律公证处","licenseNumber":"32520000MD5014978G","serviceScope":"99e673e4aabb49519d25ebc0289a9e75,c12b2e462a5348f2a3588f2eaea938c3,a0c3a0c33d7146b094ed49298f835727,26c1f15f5ce846b2bcba44cbecfeacc1,f742b707fc5d480591437f7a84696fc9,0485291fd32b4a16a463f47e5991756b,d901842add2e4d78829235dacee11609,195f7d261dc84ab48fa0048ea1ab6fbe,bfd53e41f9cf40c485502ddaaa596983,34358e50e5ea4172818e6d391f1058b2,80fbf0eaf118459dbc1a291fbe1a9a5b,17bcdff8034f429eb442929d329d9bd5","id":"200519C2W0KC96K4","provinceName":"贵州省","countyName":"南明区"},{"cityName":"贵阳市","isDeleted":0,"province":"520000","city":"520100","county":"520102","name":"贵阳市新天公证处","licenseNumber":"32520000MD50112594","serviceScope":"99e673e4aabb49519d25ebc0289a9e75","telephone":"0851\u201486402059","id":"200519C2W0KC96K5","provinceName":"贵州省","countyName":"南明区"},{"cityName":"贵阳市","isDeleted":0,"province":"520000","city":"520100","county":"520111","name":"贵阳市明珠公证处","licenseNumber":"32520000MD5011232C","telephone":"0851\u201483620231","id":"200519C2W0KGPRGC","provinceName":"贵州省","countyName":"花溪区"},{"cityName":"贵阳市","isDeleted":0,"province":"520000","city":"520100","county":"520113","name":"贵阳市南湖公证处","licenseNumber":"32520000429310300A","telephone":"0851\u201484833007","id":"200519C2W0KGPRGD","provinceName":"贵州省","countyName":"白云区"},{"cityName":"贵阳市","isDeleted":0,"province":"520000","city":"520100","county":"520115","name":"贵阳市诚信公证处","licenseNumber":"32520000K363497016","telephone":"0851\u201484813903","id":"200519C2W0KGPRGF","provinceName":"贵州省","countyName":"观山湖区"},{"cityName":"贵阳市","isDeleted":0,"province":"520000","city":"520100","county":"520181","name":"清镇市公证处","licenseNumber":"32520000MD50112407","telephone":"0851\u201482522158","id":"200519C2W0KN48DP","provinceName":"贵州省","countyName":"清镇市"},{"cityName":"贵阳市","isDeleted":0,"province":"520000","city":"520100","county":"520123","name":"修文县公证处","licenseNumber":"325200000097200639","telephone":"0851\u201482372559","id":"200519C2W0KN48DR","provinceName":"贵州省","countyName":"修文县"},{"cityName":"贵阳市","isDeleted":0,"province":"520000","city":"520100","county":"520121","name":"开阳县公证处","licenseNumber":"125201214299512201","telephone":"0851\u201487221135","id":"200519C2W0KSGTC0","provinceName":"贵州省","countyName":"开阳县"},{"cityName":"贵阳市","isDeleted":0,"province":"520000","city":"520100","county":"520122","name":"息烽县公证处","licenseNumber":"32520000009718334C","telephone":"0851\u201487721154","id":"200519C2W0KSGTC1","provinceName":"贵州省","countyName":"息烽县"}]
         * funcName : page
         * firstPage : true
         * maxResults : 100
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
             * cityName : 贵阳市
             * isDeleted : 0
             * province : 520000
             * city : 520100
             * county : 520115
             * name : 贵阳市国信公证处
             * licenseNumber : 32520000MD5016009P
             * telephone : 0851—85872405
             * id : 200519C2W0K5F4PH
             * provinceName : 贵州省
             * countyName : 观山湖区
             * address : 贵州省贵阳市云岩区中华北路289号6-7楼
             * axis : 106.712761,26.579543
             * serviceTime : 上午9：00--12：00，下午1：30--5：30，节假日可预约办证。
             * serviceScope : 99e673e4aabb49519d25ebc0289a9e75,c12b2e462a5348f2a3588f2eaea938c3,a0c3a0c33d7146b094ed49298f835727,26c1f15f5ce846b2bcba44cbecfeacc1,f742b707fc5d480591437f7a84696fc9,0485291fd32b4a16a463f47e5991756b,d901842add2e4d78829235dacee11609,195f7d261dc84ab48fa0048ea1ab6fbe,d245e0b56e1740efbb6ccd202016523c,bfd53e41f9cf40c485502ddaaa596983,34358e50e5ea4172818e6d391f1058b2,80fbf0eaf118459dbc1a291fbe1a9a5b,c537e68b518146379c9f191374b5004e,fff25717ecba4a21a1d0b3fe159efaf7,17bcdff8034f429eb442929d329d9bd5,76799ff8959945c78be2913ef5f1cc83
             * introduction : 贵州省责阳市立诚公证处(原名贵阳市云岩区公证处)成立于1984年，是云岩区司法局所属单位。历经30余年的发展，我处现在拥有一支高素质的公证人员队伍。其中，执业公证员4名、公证员助理18名、后勤行政人员8名。长期为我区轨道交通、1.5环、人民大道、棚户区改造、云岩区法院强制执行等工作提供了坚强的法律保障，为推进我区的经济、社会建设起到了不可替代的作用。历年来我处多次受到省厅、市局及区委区政府的好评。同时，也得到了社会的广泛认可和信赖，为我区经济建设、构建和谐社会作出了应有的贡献。2017年以来，按照省、市、区推进公证机构体制改革总体部署，经云岩区编制委员会办公室批复，通过新设立事业单位的方式，立诚公证处改制为云岩区司法局所属股级公益二类事业单位，并于2018年5月18日取得《事业单位法人证书》，逐步落实并完善各项便民服务举措，进一步加强公证标准化建设。立诚公证处贴近群众，以专业化家事法律服务为立足，开展各项公证及法律服务业务，业务范围如下：
             1、办理家事法律服务类公证业务，包括办理委托、声明、继承、赠与、财产约定、协议书等公证，根据申请人的申请和委托代为办理不动产转移、抵押等登记手续；
             2、办理权益保护类公证业务，例如保护知识产权、保护名誉权、肖像权等，包括相关的购买物品，保全现状，保全网页、电子邮件、手机短信、微信证据等保全证据公证；
             3、办理金融法律服务类公证业务，包括为金融机构办理经济同、办理赋情权文书制执行效力公证，代为送达催收函件等；
             4、办理辅助人民法院工作类公证业务，包括依据人民法院的委托参与诉前调解、代为调查取证、代为办理查封财产手续、代为送达法律文书、在人民法院强制执行工作中办理清点、封存物品等公证；
             5、办理提存类公证，包括钱款以及物品等的提存、商品交易货款监管等；
             6、办理抵押登记类公证业务，办理动产抵押登记、权利质押登根据申请人的申请和委托，代为办理抵押登记；
             7、提供公证法律咨询类服务、受聘担任法律顾问等；
             8、法律允许的其他非诉讼法律服务业务。

             贵州省贵阳市立诚公证处地址：贵阳市云岩区宝山北路217号(市药材公司内）
             业务咨询电话：0851-86829710
             办公室电话/传真：0851-86772145
             */

            @JsonProperty("cityName")
            private String cityName;
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
            @JsonProperty("licenseNumber")
            private String licenseNumber;
            @JsonProperty("telephone")
            private String telephone;
            @JsonProperty("id")
            private String id;
            @JsonProperty("provinceName")
            private String provinceName;
            @JsonProperty("countyName")
            private String countyName;
            @JsonProperty("address")
            private String address;
            @JsonProperty("axis")
            private String axis;
            @JsonProperty("serviceTime")
            private String serviceTime;
            @JsonProperty("serviceScope")
            private String serviceScope;
            @JsonProperty("introduction")
            private String introduction;
        }
    }
}
