package com.java.firsttest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.java.firsttest.*")
@EnableEurekaClient
@EnableCaching
@MapperScan("com.java.firsttest.mapper")
public class FirstTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstTestApplication.class, args);
    }

}
