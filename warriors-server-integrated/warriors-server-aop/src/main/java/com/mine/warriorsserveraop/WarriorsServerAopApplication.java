package com.mine.warriorsserveraop;

import com.mine.warriorsservercommon.config.aop.LogAspect;
import com.mine.warriorsservercommon.config.exception.GlobalExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RefreshScope
public class WarriorsServerAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarriorsServerAopApplication.class, args);
    }

}

