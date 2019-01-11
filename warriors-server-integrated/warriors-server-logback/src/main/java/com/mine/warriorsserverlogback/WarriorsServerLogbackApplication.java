package com.mine.warriorsserverlogback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WarriorsServerLogbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarriorsServerLogbackApplication.class, args);
    }

}

