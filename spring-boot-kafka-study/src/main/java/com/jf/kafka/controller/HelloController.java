package com.jf.kafka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 潇潇暮雨
 * @create 2018-10-05   10:36
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello kafka";
    }
}