package com.jf.disruptor.controller;

import com.jf.common.aspect.log.RpcApi;
import com.jf.model.response.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/hello")
    @RpcApi(apiId = "11111")
    public CommonResult<String> hello() {
        return CommonResult.success("hello");
    }
}
