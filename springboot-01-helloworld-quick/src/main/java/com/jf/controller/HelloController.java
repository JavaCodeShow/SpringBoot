package com.jf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 潇潇暮雨
 * @create 2018-09-26   22:42
 */
@RestController
public class HelloController {

    @Value("${person.name}")
    private String name;

    @RequestMapping(value = {"/hello", "/hello1"})
    public String fun() {
        return "hello springBoot quick";
    }

    @RequestMapping("/sayHello")
    public String sayHello() {
        return "hello " + name;
    }
}

