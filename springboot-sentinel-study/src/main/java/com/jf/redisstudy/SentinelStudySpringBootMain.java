package com.jf.redisstudy;

import com.jf.common.utils.config.JfCommonUtilsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author 江峰
 * @create 2020-03-21 10:56
 */
@SpringBootApplication
@Import({JfCommonUtilsConfig.class})
public class SentinelStudySpringBootMain {
    public static void main(String[] args) {
        SpringApplication.run(SentinelStudySpringBootMain.class, args);
    }
}
