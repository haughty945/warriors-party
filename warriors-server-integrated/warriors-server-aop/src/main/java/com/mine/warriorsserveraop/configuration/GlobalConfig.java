package com.mine.warriorsserveraop.configuration;

import com.mine.warriorsservercommon.config.aop.LogAspect;
import com.mine.warriorsservercommon.config.exception.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
