package com.jf.websocket.controller;

import com.jf.model.response.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {


    @GetMapping("/hello")
    public CommonResult<String> hello() {
        System.out.println("hello");
        return CommonResult.success("hello");
    }
}
