package com.mine.warriorsserverasync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RefreshScope
@EnableAsync        // 开启异步调用
public class WarriorsServerAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarriorsServerAsyncApplication.class, args);
    }
}

