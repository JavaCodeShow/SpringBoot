package com.jf.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author 潇潇暮雨
 * @create 2018-09-29   9:25
 */
@Component
@PropertySource(value={"classpath:person.properties"})
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
