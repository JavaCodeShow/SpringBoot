package com.jf.redisstudy.controller;

import com.jf.common.utils.aspect.log.MethodLogger;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * redis使用在单元测试里面
 *
 * @author 江峰
 * @create 2020-03-20 14:54
 */
@RestController
@Slf4j
public class HelloController {
    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping("/")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f52")
    public String hello() {
        RLock lock = this.redissonClient.getLock("hello");
        try {
            boolean success = lock.tryLock(0, 10, TimeUnit.SECONDS);
            if (success) {
                TimeUnit.SECONDS.sleep(5);
            }
            return "hello " + success;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }

}
