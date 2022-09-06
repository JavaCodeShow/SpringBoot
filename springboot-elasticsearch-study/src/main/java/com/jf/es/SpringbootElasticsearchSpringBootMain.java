package com.jf.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author 江峰
 * @create 2020-03-21   10:56
 */
@ServletComponentScan("com.jf")
@SpringBootApplication
public class SpringbootElasticsearchSpringBootMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootElasticsearchSpringBootMain.class, args);
    }
}
