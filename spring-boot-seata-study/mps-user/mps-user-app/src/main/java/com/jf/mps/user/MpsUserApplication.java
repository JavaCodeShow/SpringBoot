package com.jf.mps.user;

import com.jf.common.utils.PropertyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class MpsUserApplication {

    private static final Logger logger = LoggerFactory.getLogger(MpsUserApplication.class);

    public static void main(String[] args) {
        try {
            PropertyRepository.initCenter("global.properties");
            SpringApplication.run(MpsUserApplication.class, args);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            System.exit(0);
        }

    }
}
