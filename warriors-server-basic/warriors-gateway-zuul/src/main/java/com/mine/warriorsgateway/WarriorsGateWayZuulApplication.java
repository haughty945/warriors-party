package com.mine.warriorsgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Program: warriors-party
 * @Description: 网关启动类
 * @Author: Mine.Lee
 * @Create: 2019-01-15 18:42
 * @Version: v1.0
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@RefreshScope
public class WarriorsGateWayZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarriorsGateWayZuulApplication.class, args);
    }

}
