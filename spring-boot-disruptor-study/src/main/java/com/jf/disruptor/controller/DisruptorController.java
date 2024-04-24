package com.jf.disruptor.controller;

import com.jf.disruptor.message.DisruptorMqService;
import com.jf.model.response.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class DisruptorController {

    @Autowired
    private DisruptorMqService disruptorMqService;

    private final AtomicInteger counter = new AtomicInteger(0);

    @GetMapping("/disruptor_test")
    // @RpcApi(apiId = "222222222")
    public CommonResult<String> hello() {
        int i = counter.incrementAndGet();
        disruptorMqService.sayHelloMq(i, "hello-" + i);
        // TimeUnit.SECONDS.sleep(3);
        return CommonResult.success("disruptor_test");
    }
}
