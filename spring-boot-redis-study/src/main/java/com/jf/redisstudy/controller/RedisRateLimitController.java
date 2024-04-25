package com.jf.redisstudy.controller;

import com.jf.common.redis.manager.lock.DistributedLockManager;
import com.jf.common.utils.time.LocalDateTimeUtil;
import com.jf.model.enums.GlobalErrorCodeEnum;
import com.jf.model.exception.BizException;
import com.jf.model.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Lazy
public class RedisRateLimitController {

    @RequestMapping("/redis_rate_limit")
    public CommonResult<String> hello() {

        RedissonClient redissonClient = DistributedLockManager.getRedissonClient();
        RRateLimiter rateLimiter = redissonClient.getRateLimiter("hello");
        if (!rateLimiter.isExists()) {
            rateLimiter.trySetRate(RateType.OVERALL, 100, 1, RateIntervalUnit.SECONDS);
        }
        boolean acquire = rateLimiter.tryAcquire();
        if (!acquire) {
            System.out.println("失败--" + LocalDateTimeUtil.getStringTimeOfNow());
            throw new BizException(GlobalErrorCodeEnum.SERVICE_BUSY);
        } else {
            System.out.println("成功============" + LocalDateTimeUtil.getStringTimeOfNow());
        }
        return CommonResult.success("hello springboot-redis");
    }
}
