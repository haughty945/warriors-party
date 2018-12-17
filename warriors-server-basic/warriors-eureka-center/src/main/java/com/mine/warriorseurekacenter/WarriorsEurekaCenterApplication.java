package com.mine.warriorseurekacenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WarriorsEurekaCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarriorsEurekaCenterApplication.class, args);
    }

}

