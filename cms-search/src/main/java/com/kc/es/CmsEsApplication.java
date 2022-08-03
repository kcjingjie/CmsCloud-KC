package com.kc.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CmsEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsEsApplication.class, args);
    }

}
