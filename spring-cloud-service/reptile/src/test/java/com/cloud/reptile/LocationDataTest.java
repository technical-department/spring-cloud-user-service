package com.cloud.reptile;

import com.alibaba.fastjson.JSONObject;
import com.cloud.reptile.dto.ChinaRegionsInfo;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 项目名称：spring-cloud-service
 * 类 名 称：LocationDataTest
 * 类 描 述：TODO
 * 创建时间：2021/2/26 下午8:48
 * 创 建 人：chenyouhong
 */
public class LocationDataTest {

    //需要抓取的网页地址
//    private static final String URL = "http://www.mca.gov.cn//article/sj/xzqh/2020/202006/202008310601.shtml";
    private static final String URL = "http://preview.www.mca.gov.cn/article/sj/xzqh/2020/2020/202101041104.html";

    public static void main(String[] args) throws IOException {
        List<ChinaRegionsInfo> regionsInfoList = new ArrayList<>();
        //抓取网页信息
        Document document = Jsoup.connect(URL).get();
        //获取真实的数据体
        Element element = document.getElementsByTag("tbody").get(0);
        String provinceCode = "";//省级编码
        String cityCode = "";//市级编码
        if (Objects.nonNull(element)) {
            Elements trs = element.getElementsByTag("tr");
            for (int i = 3; i < trs.size(); i++) {
                Elements tds = trs.get(i).getElementsByTag("td");
                if (tds.size() < 3) {
                    continue;
                }
                Element td1 = tds.get(1);//行政区域编码
                Element td2 = tds.get(2);//行政区域名称
                if (StringUtils.isNotEmpty(td1.text())) {
                    if (td1.classNames().contains("xl7030796")) {
                        if (td2.toString().contains("span")) {
                            //市级
                            ChinaRegionsInfo chinaRegions = new ChinaRegionsInfo();
                            chinaRegions.setCode(td1.text());
                            chinaRegions.setName(td2.text());
                            chinaRegions.setType(2);
                            chinaRegions.setParentCode(provinceCode);
                            regionsInfoList.add(chinaRegions);
                            cityCode = td1.text();
                        } else {
                            //省级
                            ChinaRegionsInfo chinaRegions = new ChinaRegionsInfo();
                            chinaRegions.setCode(td1.text());
                            chinaRegions.setName(td2.text());
                            chinaRegions.setType(1);
                            chinaRegions.setParentCode("");
                            regionsInfoList.add(chinaRegions);
                            provinceCode = td1.text();
                        }

                    } else {
                        //区或者县级
                        ChinaRegionsInfo chinaRegions = new ChinaRegionsInfo();
                        chinaRegions.setCode(td1.text());
                        chinaRegions.setName(td2.text());
                        chinaRegions.setType(3);
                        chinaRegions.setParentCode(StringUtils.isNotEmpty(cityCode) ? cityCode : provinceCode);
                        regionsInfoList.add(chinaRegions);
                    }
                }
            }
        }
        //打印结果
        System.out.println(JSONObject.toJSON(regionsInfoList));
    }

}


