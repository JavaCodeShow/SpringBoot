package com.jf.mps.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.jf")
@EnableHystrix
@ServletComponentScan("com.jf")
@ComponentScan(basePackages = "com.jf")
public class MpsAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpsAccountApplication.class, args);

    }
}
