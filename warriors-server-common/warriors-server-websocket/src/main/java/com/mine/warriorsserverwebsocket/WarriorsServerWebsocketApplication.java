package com.mine.warriorsserverwebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages ="com.mine.warriorsserverwebsocket")
@SpringBootApplication
@EnableScheduling
public class WarriorsServerWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarriorsServerWebsocketApplication.class, args);
    }

}

