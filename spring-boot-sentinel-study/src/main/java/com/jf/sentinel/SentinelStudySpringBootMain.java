package com.jf.sentinel;

import com.jf.common.utils.PropertyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 江峰
 * @create 2020-03-21 10:56
 */
@Slf4j
@SpringBootApplication
public class SentinelStudySpringBootMain {
    public static void main(String[] args) {
        try {
            PropertyRepository.initCenter("global.properties");
        } catch (Exception e) {
            log.error("服务启动加载配置文件失败，失败原因：", e);
            System.exit(0);
        }
        SpringApplication.run(SentinelStudySpringBootMain.class, args);
    }
}
