package com.jf.nacos;

import com.jf.common.utils.PropertyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@Slf4j
public class NacosConsumerApplication {

    public static void main(String[] args) {
        try {
            PropertyRepository.initCenter("global.properties");
        } catch (Exception e) {
            log.error("服务启动加载配置文件失败，失败原因：", e);
            System.exit(0);
        }
        SpringApplication.run(NacosConsumerApplication.class, args);
    }
}
