package com.mine.warriorsserverrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author : john_lee
 * @Date : 2018/12/23
 * @Remark : rabbitMq服务启动类
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RefreshScope
public class WarriorsServerRabbitMQApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarriorsServerRabbitMQApplication.class, args);
    }

}
