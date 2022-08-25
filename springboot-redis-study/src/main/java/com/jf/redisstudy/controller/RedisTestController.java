package com.jf.redisstudy.controller;

import com.jf.common.aspect.log.MethodLogger;
import com.jf.common.aspect.meta.enums.GlobalErrorCodeEnum;
import com.jf.common.aspect.result.BaseResult;
import com.jf.common.redis.annotation.DistributeLock;
import com.jf.common.redis.annotation.ReSubmitLock;
import com.jf.common.redis.generator.CacheKeyGenerator;
import com.jf.common.redis.generator.LockKeyGenerator;
import com.jf.common.redis.manager.cache.GlobalCacheManager;
import com.jf.common.redis.manager.lock.DistributeLockManager;
import com.jf.redisstudy.domain.enums.RedisStudyCacheKeyEnum;
import com.jf.redisstudy.domain.enums.RedisStudyLockKeyEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
    private GlobalCacheManager globalCacheManager;

    @Autowired
    private DistributeLockManager distributeLockManager;

    @GetMapping(value = "/redis/testDistributeLock")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f51")
    @DistributeLock(lockKey = "6221f12e0a849a10a89f9f00")
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
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f5a")
    @ReSubmitLock
    public BaseResult testReSubmitLock() {

        return BaseResult.success();
    }


    /**
     * 测试手动添加分布式锁
     */
    @GetMapping("/redis/distributeLockService_tryLock")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f62")
    public BaseResult<Boolean> testDistributeLockServiceTryLock() {

        String lockKeyName = LockKeyGenerator.generateLockKey(RedisStudyLockKeyEnum.MIN_PRICE, "111");
        log.info("lockKeyName = [{}]", lockKeyName);
        boolean flag = distributeLockManager.tryLock(lockKeyName);
        log.info("获取锁的结果 = {}", flag);
        if (!flag) {
            return BaseResult.fail(GlobalErrorCodeEnum.NOT_GET_LOCK);
        }
        try {
            System.out.println("开始执行业务逻辑");
        } finally {
            distributeLockManager.unlock(lockKeyName);
        }

        return BaseResult.success(true);
    }

    /**
     * String 类型缓存
     */
    @GetMapping("/redis/cache")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f67")
    public BaseResult<String> testCache() {

        String cacheKeyName = CacheKeyGenerator.generateCacheKey(RedisStudyCacheKeyEnum.MIN_PRICE, "222");
        log.info("cacheKeyName = [{}]", cacheKeyName);
        String value = globalCacheManager.get(cacheKeyName);
        if (StringUtils.isBlank(value)) {
            globalCacheManager.set(cacheKeyName, "333");
        }

        return BaseResult.success(value);
    }
}
