package com.java.frontendsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(scanBasePackages = {"com.java.frontendsystem.controller"})
@EnableEurekaClient
@EnableFeignClients("com.java.frontendsystem.feign")
public class FrontEndSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontEndSystemApplication.class, args);
    }

}
