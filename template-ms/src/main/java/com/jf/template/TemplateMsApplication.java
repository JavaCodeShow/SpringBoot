package com.jf.template;

import com.jf.common.redis.config.JfCommonRedisConfig;
import com.jf.common.utils.config.JfCommonUtilsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({JfCommonUtilsConfig.class, JfCommonRedisConfig.class})
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class TemplateMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateMsApplication.class, args);
    }
}
