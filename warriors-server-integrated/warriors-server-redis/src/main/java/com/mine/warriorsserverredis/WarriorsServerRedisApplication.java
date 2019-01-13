package com.mine.warriorsserverredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@EnableScheduling
public class WarriorsServerRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarriorsServerRedisApplication.class, args);
    }

}

