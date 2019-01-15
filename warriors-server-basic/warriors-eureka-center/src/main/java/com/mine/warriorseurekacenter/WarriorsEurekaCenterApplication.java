package com.mine.warriorseurekacenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Program: warriors-party
 * @Description: 注册中心启动类
 * @Author: Mine.Lee
 * @Create: 2019-01-15 18:35
 * @Version: v1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class WarriorsEurekaCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarriorsEurekaCenterApplication.class, args);
    }

}