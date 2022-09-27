package com.jf.mybatis.controller;

import com.jf.model.result.BaseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public BaseResult index() {
        return BaseResult.success("spring-boot-mybatis-study");
    }

    @GetMapping("/hello")
    public BaseResult hello() {
        return BaseResult.success("hello");
    }
}
