package com.jf.redisstudy;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 江峰
 * @create 2020-03-21   10:56
 */
@SpringBootApplication
@Slf4j
@EnableApolloConfig
public class ApolloSpringBootMain {
    public static void main(String[] args) {
        SpringApplication.run(ApolloSpringBootMain.class, args);
    }
}
