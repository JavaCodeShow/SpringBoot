package com.jf.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @author 潇潇暮雨
 * @create 2018-09-29   9:25
 */
@Component
@PropertySource(value={"classpath:person.properties"})
// @ConfigurationProperties(prefix = "person")
public class Person {
    @Value("${person.name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
