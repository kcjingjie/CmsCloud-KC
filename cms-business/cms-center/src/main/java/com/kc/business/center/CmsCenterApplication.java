package com.kc.business.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class CmsCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsCenterApplication.class, args);
    }

}
