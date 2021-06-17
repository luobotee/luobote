package com.java.eurakeserver002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurakeServer002Application {

    public static void main(String[] args) {
        SpringApplication.run(EurakeServer002Application.class, args);
    }

}
