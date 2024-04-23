package com.jf.disruptor;

import com.jf.common.utils.PropertyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DisruptorApplication {

    public static void main(String[] args) {
        try {
            PropertyRepository.initCenter("global.properties");
        } catch (Exception e) {
            log.error("服务启动加载配置文件失败，失败原因：", e);
            System.exit(0);
        }
        SpringApplication.run(DisruptorApplication.class, args);
    }
}
