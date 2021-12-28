package com.jf.redisstudy.controller;

import com.jf.common.redis.annotation.DistributeLock;
import com.jf.common.redis.annotation.ReSubmitLock;
import com.jf.common.redis.service.cache.RedisCacheService;
import com.jf.common.redis.service.lock.DistributeLockService;
import com.jf.common.utils.aspect.log.MethodLogger;
import com.jf.common.utils.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-03-23 18:55
 * @since: 2.22.1
 */
@RestController
@Slf4j
public class RedisTestController {

    @Autowired
    private RedisCacheService redisCacheService;

    @Autowired
    private DistributeLockService distributeLockService;

    @GetMapping(value = "/redis/testDistributeLock")
    @MethodLogger
    @DistributeLock(lockKey = "orderId")
    public BaseResult testDistributeLock() {

        System.out.println("执行相关业务...");
        System.out.println("执行相关业务.....");
        System.out.println("执行相关业务......");

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return BaseResult.success();
    }

    /**
     * 测试防止重复提交
     *
     * @return
     */
    @GetMapping("/redis/testReSubmitLock")
    @MethodLogger
    @ReSubmitLock
    public BaseResult testReSubmitLock() {

        return BaseResult.success();
    }


    /**
     * 测试手动添加分布式锁
     *
     * @return
     */
    @GetMapping("/redis/distributeLockService_tryLock")
    @MethodLogger
    public BaseResult<Boolean> testDistributeLockServiceTryLock() {
        boolean flag = distributeLockService.tryLock("666");
        log.info("获取锁的结果 = {}", flag);
        return BaseResult.success(flag);
    }

}
