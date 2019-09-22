package com.jf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author 潇潇暮雨
 * @create 2018-09-26   22:42
 */
@RestController
public class HelloController {
    @Autowired
    ApplicationContext applicationContext;
    @Value("${person.name}")
    private String name;

    @RequestMapping(value = {"/hello", "/hello1"})
    public String fun() {
        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
        return "hello springBoot quick";
    }

    @RequestMapping("/sayHello")
    public String sayHello() {
        return "hello " + name;
    }
}

