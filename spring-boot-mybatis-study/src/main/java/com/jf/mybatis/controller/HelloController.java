package com.jf.mybatis.controller;

import com.jf.model.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("/")
    @Transactional
    public CommonResult<String> index() {
        return CommonResult.success("spring-boot-mybatis-study");
    }

    @GetMapping("/hello")
    public CommonResult<String> hello() {
        return CommonResult.success("hello");
    }
}
