package com.mine.warriorsserverasync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @program: warriors-party
 * @description: 异步任务启动类
 * @author: Mine.Lee
 * @create: 2019-01-19 17:24
 * @version: v1.0
 * @remark: ..
 */
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@EnableAsync        // 开启异步调用
public class WarriorsServerAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarriorsServerAsyncApplication.class, args);
    }
}

