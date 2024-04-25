package com.jf.redisstudy.controller;

import com.jf.common.redis.manager.lock.DistributedLockManager;
import com.jf.common.utils.time.LocalDateTimeUtil;
import com.jf.model.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Lazy
public class LimitController {

    @Autowired
    private DistributedLockManager distributedLockManager;

    private RRateLimiter rateLimiter;

    // @PostConstruct
    // public void init() {
    //     RedissonClient redissonClient = DistributedLockManager.getRedissonClient();
    //     rateLimiter = redissonClient.getRateLimiter("hello");
    //     rateLimiter.trySetRate(RateType.OVERALL, 1, 2, RateIntervalUnit.SECONDS);
    //     log.info("LimitController init success");
    // }

    @RequestMapping("/redis_rate_limit")
    // @RpcApi(apiId = "6221f12e0a849a10a89f9000")
    public CommonResult<String> hello() {
        // rateLimiter.acquire();
        RedissonClient redissonClient = DistributedLockManager.getRedissonClient();
        rateLimiter = redissonClient.getRateLimiter("hello");
        rateLimiter.trySetRate(RateType.OVERALL, 1, 2, RateIntervalUnit.SECONDS);
        System.out.println(LocalDateTimeUtil.getStringTimeOfNow());
        return CommonResult.success("hello springboot-redis");
    }
}
