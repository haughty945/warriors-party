package com.mine.warriorsservermybatisplus.configuration;

import com.mine.warriorsservercommon.config.aop.LogAspect;
import com.mine.warriorsservercommon.config.exception.GlobalExceptionHandler;
import com.mine.warriorsservercommon.config.filter.CrossFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: warriors-party
 * @description: 全局配置类
 * @author: Mine.Lee
 * @create: 2019-01-15 20:45
 * @version: v1.0
 */
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
}
