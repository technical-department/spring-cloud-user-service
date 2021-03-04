package com.common.config;

import cn.hutool.core.exceptions.ValidateException;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 项目名称：spring-cloud-service
 * 类 名 称：RedissonConfig
 * 类 描 述：TODO
 * 创建时间：2020/11/26 下午3:39
 * 创 建 人：chenyouhong
 */
@Configuration
public class RedissonConfig {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private String port;
    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public RedissonClient redissonClient() {
        try {
            Config config = new Config();
            config.setTransportMode(TransportMode.NIO);
            config.useSingleServer().setAddress("redis://" + host + ":" + port + "").setPassword(password);
            return Redisson.create(config);
        } catch (Exception ex) {
            throw new ValidateException("加载RedissonClient配置失败！ ex: {}", ex);
        }
    }

}
