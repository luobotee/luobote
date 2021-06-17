package com.java.securityauthserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.java.securityauthserver.*")
@EnableEurekaClient
@EnableCaching
@MapperScan("com.java.securityauthserver.mapper")
public class SecurityAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityAuthServerApplication.class, args);
    }

}
