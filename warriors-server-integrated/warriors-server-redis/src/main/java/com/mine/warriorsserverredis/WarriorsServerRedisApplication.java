package com.mine.warriorsserverredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @program: warriors-party
 * @description: redis项目启动类
 * @author: Mine.Lee
 * @create: 2019-01-16 01:52
 * @version: v1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@EnableScheduling
public class WarriorsServerRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarriorsServerRedisApplication.class, args);
    }

}

