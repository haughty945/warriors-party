package com.mine.warriorsserverdynamicdatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WarriorsServerDynamicDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarriorsServerDynamicDatasourceApplication.class, args);
    }

}

