package com.jf.redisstudy.controller;

import com.jf.common.aspect.log.MethodLogger;
import com.jf.model.result.CommonResult;
import com.jf.redisstudy.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis
 *
 * @author 江峰
 * @create 2020-03-20 14:54
 */
@RestController
@Slf4j
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f52")
    public CommonResult<String> index() {
        return CommonResult.success("springboot-redis");
    }

    @RequestMapping("/hello")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9000")
    public CommonResult<String> hello() {
        // log.info("666");
        helloService.hello();
        return CommonResult.success("hello springboot-redis");
    }
}
