package com.jf.mps.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.jf")
@ServletComponentScan(basePackages = "com.jf")
@ComponentScan(basePackages = "com.jf")
public class MpsUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpsUserApplication.class, args);

    }
}
