package com.jf.redisstudy.controller;

import com.jf.common.aspect.log.MethodLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * redis
 *
 * @author 江峰
 * @create 2020-03-20 14:54
 */
@RestController
@Slf4j
public class HelloController {

    @RequestMapping("/")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f52")
    public String hello() {
        log.info("666");
        String name = getName("zhangsan");
        System.out.println(name);
        return "springboot-redis";
    }

    public String getName(String name) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name + "李四";
    }
}
