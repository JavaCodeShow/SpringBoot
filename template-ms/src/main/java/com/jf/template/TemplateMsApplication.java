package com.jf.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.jf")
@EnableHystrix
@ComponentScan(basePackages = "com.jf")
public class TemplateMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateMsApplication.class, args);
    }
}
