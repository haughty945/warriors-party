package com.mine.warriorsservercommon.config;

import com.mine.warriorsservercommon.utils.RestTemplateUtil;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: warriors-party
 * @description: 全局配置
 * @author: Mine.Lee
 * @create: 2019-01-15 19:52
 * @version: v1.0
 */
@Configuration
public class GlobalConfig {

    @Bean
    @LoadBalanced
    RestTemplateUtil restTemplateUtil() {
        return new RestTemplateUtil();
    }

}
