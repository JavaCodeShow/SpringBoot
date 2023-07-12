package com.jf.redisstudy.controller;

import com.jf.model.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ApolloController {

    @Value("${test:默认值}")
    private String test;

    @Value("${timeout:默认值}")
    private String timeout;

    @RequestMapping("/apollo_test")
    public CommonResult<String> apolloTest() {
        System.out.println("test:" + test);
        System.out.println("timeout:" + timeout);
        return CommonResult.success("test:" + test);
    }


}