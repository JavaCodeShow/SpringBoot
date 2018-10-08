package com.jf;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication :  说明这是一个springBoot应用
 * @ImportResource : 加载spring的配置文件
 */

//@ImportResource("classpath:beans.xml")
@SpringBootApplication
public class Springboot01HelloworldQuickApplication {

    public static void main(String[] args) {
        //启动这个web应用
        SpringApplication.run(Springboot01HelloworldQuickApplication.class, args);
    }
}
