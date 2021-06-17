package com.java.utilsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UtilsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtilsServerApplication.class, args);
    }

}
