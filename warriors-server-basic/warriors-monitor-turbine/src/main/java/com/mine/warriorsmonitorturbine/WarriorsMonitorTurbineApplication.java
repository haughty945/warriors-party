package com.mine.warriorsmonitorturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
@EnableHystrix
@EnableTurbine
@EnableCircuitBreaker
public class WarriorsMonitorTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarriorsMonitorTurbineApplication.class, args);
    }

}

