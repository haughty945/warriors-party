package com.mine.warriorsserverribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@RefreshScope
public class WarriorsServerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarriorsServerRibbonApplication.class, args);
    }

}

