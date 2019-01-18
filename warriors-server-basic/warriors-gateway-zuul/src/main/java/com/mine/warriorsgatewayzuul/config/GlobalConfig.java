package com.mine.warriorsgatewayzuul.config;

import com.mine.warriorsservercommon.config.aop.LogAspect;
import com.mine.warriorsservercommon.config.exception.GlobalExceptionHandler;
import com.mine.warriorsservercommon.config.filter.CrossFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Program: warriors-party
 * @Description: 全局配置类 --- 把我们需要注入IOC容器的类都配置进来
 * @Author: Mine.Lee
 * @Create: 2019-01-15 18:42
 * @Version: v1.0
 */
//@Configuration
public class GlobalConfig {

    /**
     * @Description 日志记录
     * @Author Mine.Lee
     * @Date 2019/1/15 18:45
     * @Param []
     * @Return com.mine.warriorsservercommon.config.aop.LogAspect
     */
    @Bean
    LogAspect logAspect() {
        return new LogAspect();
    }

    /**
     * @Description 统一异常处理
     * @Author Mine.Lee
     * @Date 2019/1/15 18:45
     * @Param []
     * @Return com.mine.warriorsservercommon.config.exception.GlobalExceptionHandler
     */
    @Bean
    GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    /**
     * @Description 跨域过滤器
     * @Author Mine.Lee
     * @Date 2019/1/15 18:44 
     * @Param []
     * @Return com.mine.warriorsservercommon.config.filter.CrossFilter
     */
    @Bean
    CrossFilter CrossFilter() {
        return new CrossFilter();
    }
}
