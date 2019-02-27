package com.mine.warriorsserveresayexcel;

import com.mine.warriorsservercommon.config.aop.LogAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WarriorsServerEsayPoiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarriorsServerEsayPoiApplication.class, args);
    }

    @Bean
    LogAspect logAspect(){
        return new LogAspect();
    }

}
