package com.jf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

// 来标注一个主程序类，说明这是一个spring Boot应用
@SpringBootApplication
public class SpringBootStudyApplication {

    public static void main(String[] args) {
        // 启动spring应用
        SpringApplication.run(SpringBootStudyApplication.class, args);
    }
}
