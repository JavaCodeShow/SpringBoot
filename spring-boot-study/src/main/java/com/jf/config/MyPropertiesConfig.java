package com.jf.config;

import com.jf.pojo.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author 潇潇暮雨
 * @create 2018-10-05   12:55
 */

@Configuration
@ImportResource("classpath:beans.xml")
public class MyPropertiesConfig {

    @Bean
    public Cat cat(){
        return new Cat();
    }
}
