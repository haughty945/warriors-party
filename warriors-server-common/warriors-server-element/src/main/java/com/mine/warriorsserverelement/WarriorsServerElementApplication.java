package com.mine.warriorsserverelement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@RefreshScope
public class WarriorsServerElementApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarriorsServerElementApplication.class, args);
    }

    @Value("${server.port}")
    private String port;

    @RequestMapping("hi")
    public String hi() {
        return "WarriorsServerElementApplication + 服务器中的端口为" + port;
    }

}

