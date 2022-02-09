package com.ibagroup.math;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan("com.ibagroup.common")
public class MathApplication {
    public static void main(String[] args){
        SpringApplication.run(MathApplication.class, args);
    }
}
