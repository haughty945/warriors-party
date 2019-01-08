package com.mine.warriorsservercommon.config;

import com.mine.warriorsservercommon.utils.RestTemplateUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfig {

    @Bean
    RestTemplateUtil restTemplateUtil() {
        return new RestTemplateUtil();
    }

}
