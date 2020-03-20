package com.jf.redisstudy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * redis使用在单元测试里面
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
