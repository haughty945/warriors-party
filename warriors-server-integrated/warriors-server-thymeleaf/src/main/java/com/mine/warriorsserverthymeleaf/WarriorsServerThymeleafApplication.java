package com.mine.warriorsserverthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @program: warriors-party
 * @description: thymeleaf项目启动类
 * @author: Mine.Lee
 * @create: 2019-01-16 01:52
 * @version: v1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class WarriorsServerThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarriorsServerThymeleafApplication.class, args);
    }

}

