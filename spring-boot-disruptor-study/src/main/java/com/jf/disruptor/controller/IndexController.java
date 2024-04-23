package com.jf.disruptor.controller;

import com.jf.common.aspect.log.RpcApi;
import com.jf.disruptor.log.DisruptorTest;
import com.jf.model.response.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class IndexController {

    @GetMapping("/hello")
    @RpcApi(apiId = "11111")
    public CommonResult<String> hello() throws InterruptedException {
        System.out.println("hello");
        DisruptorTest.run();
        TimeUnit.SECONDS.sleep(1);
        return CommonResult.success("hello");
    }
}
