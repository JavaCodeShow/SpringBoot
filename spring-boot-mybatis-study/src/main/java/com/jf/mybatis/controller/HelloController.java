package com.jf.mybatis.controller;

import com.jf.model.response.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public CommonResult index() {
        return CommonResult.success("spring-boot-mybatis-study");
    }

    @GetMapping("/hello")
    public CommonResult hello() {
        return CommonResult.success("hello");
    }
}
