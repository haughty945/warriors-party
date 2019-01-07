package com.mine.warriorsserverquartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@RefreshScope
public class WarriorsServerQuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarriorsServerQuartzApplication.class, args);
    }

}

