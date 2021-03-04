package com.cloud.user.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 项目名称：spring-cloud-service
 * 类 名 称：DozerBeanMapperConfig
 * 类 描 述：TODO
 * 创建时间：2021/2/10 下午8:47
 * 创 建 人：chenyouhong
 */
@Configuration
public class DozerBeanMapperConfig {

    @Bean
    public DozerBeanMapper dozerBeanMapper() {
        return new DozerBeanMapper();
    }

}
