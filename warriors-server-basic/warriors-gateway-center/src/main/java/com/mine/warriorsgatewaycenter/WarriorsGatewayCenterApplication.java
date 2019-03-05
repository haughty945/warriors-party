package com.mine.warriorsgatewaycenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Program: warriors-party
 * @Description: 网关启动类
 * @Author: Mine.Lee
 * @Create: 2019-01-15 18:42
 * @Version: v1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WarriorsGatewayCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarriorsGatewayCenterApplication.class, args);
    }

}
