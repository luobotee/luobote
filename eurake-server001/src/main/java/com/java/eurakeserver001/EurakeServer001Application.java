package com.java.eurakeserver001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurakeServer001Application {

    public static void main(String[] args) {
        SpringApplication.run(EurakeServer001Application.class, args);
    }

}
