package com.jf.redisstudy.controller;

import com.jf.model.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ApolloController {

    @Value("${age:默认值}")
    private String age;

    @Value("${name:默认值}")
    private String name;

    @RequestMapping("/apollo_test")
    public CommonResult<String> apolloTest() {
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        System.out.println("age:" + age);
        System.out.println("name:" + name);
        return CommonResult.success("apollo测试");
    }


}