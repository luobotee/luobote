package com.java.secondtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.java.secondtest.*")
@EnableEurekaClient
@EnableCaching
@MapperScan("com.java.secondtest.mapper")
public class SecondTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondTestApplication.class, args);
    }

}
