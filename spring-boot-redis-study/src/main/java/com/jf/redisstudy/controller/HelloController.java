package com.jf.redisstudy.controller;

import com.jf.common.aspect.log.MethodLogger;
import com.jf.model.result.CommonResult;
import com.jf.redisstudy.domain.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
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
    List<UserDTO> list = new ArrayList<>();
    @RequestMapping("/")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f52")
    public CommonResult<String> index() {

        for (int i = 0; i < 10000000; i++) {
            list.add(UserDTO.getUserOne());
        }
        System.out.println(list.size());
        System.out.println(list.get(0));
        log.info("开始睡觉了。" + Thread.currentThread().getName());

        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("666");
        return CommonResult.success("springboot-redis");
    }

    @RequestMapping("/hello")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f52")
    public CommonResult<String> hello() {
        log.info("666");
        return CommonResult.success("hello springboot-redis");
    }
}
