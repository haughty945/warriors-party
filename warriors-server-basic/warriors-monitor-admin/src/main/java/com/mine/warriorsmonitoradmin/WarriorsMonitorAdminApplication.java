package com.mine.warriorsmonitoradmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Program: warriors-party
 * @Description: 监控启动类
 * @Author: Mine.Lee
 * @Create: 2018-11-15 18:42
 * @Version: v1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
public class WarriorsMonitorAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarriorsMonitorAdminApplication.class, args);
    }

}

