package com.jf.config;

import com.jf.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author 潇潇暮雨
 * @create 2018-09-29   10:09
 */
@Configuration
@ImportResource(value={"classpath:beans.xml"})
public class BeansConfig {

//    @Bean
//    public Dog dog(){
//        System.out.println("创建了dog");
//        return new Dog();
//    }

}
