package com.jf.disruptor.controller;

import com.jf.common.aspect.log.RpcApi;
import com.jf.disruptor.message.DisruptorMqService;
import com.jf.model.response.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisruptorController {

    @Autowired
    private DisruptorMqService disruptorMqService;

    @GetMapping("/disruptor_test")
    @RpcApi(apiId = "222222222")
    public CommonResult<String> hello() {
        for (int i = 1; i <= 3; i++) {
            disruptorMqService.sayHelloMq(i, "hello-" + i);
        }
        // TimeUnit.SECONDS.sleep(3);
        return CommonResult.success("disruptor_test");
    }
}
