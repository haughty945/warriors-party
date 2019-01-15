package com.mine.warriorsconfigcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Program: warriors-party
 * @Description: 配置中心启动类
 * @Author: Mine.Lee
 * @Create: 2019-01-15 18:33
 * @Version: v1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class WarriorsConfigCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarriorsConfigCenterApplication.class);
    }
}
