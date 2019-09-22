package com.jf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 潇潇暮雨
 * @create 2019-09-16   14:19
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello() {
        return "hello";
    }
}
