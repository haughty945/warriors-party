package com.mine.warriorsserverribbon.config;

import com.mine.warriorsservercommon.config.aop.LogAspect;
import com.mine.warriorsservercommon.config.exception.GlobalExceptionHandler;
import com.mine.warriorsservercommon.config.filter.CrossFilter;
import com.mine.warriorsservercommon.utils.RestTemplateUtil;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GlobalConfig {

    @Bean
    LogAspect logAspect() {
        return new LogAspect();
    }

    @Bean
    GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    CrossFilter CrossFilter() {
        return new CrossFilter();
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @LoadBalanced
    RestTemplateUtil restTemplateUtil() {
        return new RestTemplateUtil();
    }

}
