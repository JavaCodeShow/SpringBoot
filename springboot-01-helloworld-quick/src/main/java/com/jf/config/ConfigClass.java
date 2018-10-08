package com.jf.config;

import com.jf.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 潇潇暮雨
 * @create 2018-09-28   10:48
 */

@Configuration
//@ImportResource("classpath:beans.xml")
public class ConfigClass {
//    static{
//        System.out.println("这个类加载了");
//    }

    @Bean
    public HelloService helloService1(){
        System.out.println("创建了一个id 为 helloService 的 bean");
        return new HelloService();
    }
}
