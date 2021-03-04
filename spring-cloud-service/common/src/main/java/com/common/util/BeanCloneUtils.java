package com.common.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.*;

/**
 * 项目名称：spring-cloud-service
 * 类 名 称：BeanCloneUtils
 * 类 描 述：TODO
 * 创建时间：2021/2/19 下午3:11
 * 创 建 人：chenyouhong
 */
public class BeanCloneUtils {

    private static Mapper mapper = new DozerBeanMapper();

    public BeanCloneUtils() {
    }

    public static <E> E copyTo(Object source, Class<E> destinationClass) {
        return source == null ? null : mapper.map(source, destinationClass);
    }

    public static <E> E copyToByJSON(Object source, Class<E> destinationClass) {
        if (source == null) {
            return null;
        } else {
            String json = JSON.toJSONString(source);
            return JSON.parseObject(json, destinationClass);
        }
    }

    public static <E> List<E> copyTo(List<?> source, Class<E> destinationClass) {
        if (CollectionUtils.isEmpty(source)) {
            return null;
        }
        List<E> res = new ArrayList(source.size());
        source.stream().forEach(e -> {
            res.add(copyTo(e, destinationClass));
        });

        return res;
    }

}
