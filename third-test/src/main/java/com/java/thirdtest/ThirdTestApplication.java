package com.java.thirdtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.java.thirdtest.*")
@EnableEurekaClient
@EnableCaching
@MapperScan("com.java.thirdtest.mapper")
public class ThirdTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThirdTestApplication.class, args);
    }

}
