package com.jf.redisstudy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 江峰
 * @create 2020-03-20   14:54
 */
@RestController
public class HelloController {

    @RequestMapping("/")

    public String hello() {
        return "hello";
    }
}
