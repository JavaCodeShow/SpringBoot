package com.jf.template;

import com.jf.common.utils.utils.PropertyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// @EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.jf")
@EnableHystrix
@ComponentScan(basePackages = "com.jf")
@ServletComponentScan("com.jf")
@Slf4j
public class TemplateMsApplication {

    public static void main(String[] args) {
        try {
            PropertyRepository.initCenter("template-ms.properties");
            PropertyRepository.initCenter("global.properties");
        } catch (Exception e) {
            log.error("服务启动加载配置文件失败，失败原因：", e);
            System.exit(0);
        }
        SpringApplication.run(TemplateMsApplication.class, args);
    }
}
