package com.cloud.reptile;

import cn.hutool.json.JSONUtil;
import com.cloud.ReptileApplication;
import com.cloud.reptile.model.DictionaryRegion;
import com.cloud.reptile.service.DictionaryRegionService;
import com.common.util.BeanCloneUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 项目名称：spring-cloud-service
 * 类 名 称：AreaSpider
 * 类 描 述：TODO
 * 创建时间：2021/2/26 下午9:06
 * 创 建 人：chenyouhong
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ReptileApplication.class) // 指定spring-boot的启动类
public class AreaSpider {

    @Autowired
    private DictionaryRegionService dictionaryRegionService;
    // 爬取目标
    private static final String TARGET = "http://preview.www.mca.gov.cn/article/sj/xzqh/2020/2020/202101041104.html";

    @Data
    @AllArgsConstructor
    public class Area {
        // 区域码
        private String code;
        // 区域名称
        private String name;
        // 父级
        private String parent;
    }

    @Test
    public void getAreaData() throws Exception {
// 请求网页
        List<Area> areaList = Jsoup.connect(TARGET).timeout(10000).get()
// 筛选出 tr 标签
                .select("tr")
// 筛选出 tr 下的 td 标签
                .stream().map(tr -> tr.select("td")
// 过滤 值为空的 td 标签，并转换为 td 列表
                        .stream().filter(td -> StringUtils.isNotBlank(td.text())).collect(Collectors.toList()))
// 前面提到，区域码和区域名称分别存储在 第一和第二个td，所以过滤掉不符合规范的数据行。
                .filter(e -> e.size() == 2)
// 转换为 area 对象
                .map(e -> new Area(e.get(0).text(), e.get(1).text(), calcParent(e.get(0).text()))).collect(Collectors.toList());
// 去除 第一行 "行政区划代码|单位名称"
        areaList.remove(0);
//        areaList.forEach(area -> System.out.println(JSONUtil.toJsonStr(area)));
        List<DictionaryRegion> dictionaryRegions = BeanCloneUtils.copyTo(areaList, DictionaryRegion.class);
        dictionaryRegionService.saveBatch(dictionaryRegions);

    }

    private static String calcParent(String areaCode) {
// 省 - 针对第一行特殊处理
        if (areaCode.contains("0000") || areaCode.equals("行政区划代码")) {
            return "0";
// 市
        } else if (areaCode.contains("00")) {
            return String.valueOf(Integer.parseInt(areaCode) / 10000 * 10000);
// 区
        } else {
            return String.valueOf(Integer.parseInt(areaCode) / 100 * 100);
        }
    }
}
