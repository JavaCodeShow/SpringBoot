package com.jf.redisstudy.controller;

import com.jf.common.aspect.log.RpcApi;
import com.jf.common.redis.annotation.ReSubmitLock;
import com.jf.common.redis.generator.LockKeyGenerator;
import com.jf.common.redis.manager.lock.DistributedLockManager;
import com.jf.model.enums.GlobalErrorCodeEnum;
import com.jf.model.response.CommonResult;
import com.jf.redisstudy.domain.enums.RedisStudyLockKeyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class LockTestController {

    @Autowired
    private DistributedLockManager distributedLockManager;

    /**
     * 测试防止重复提交
     */
    @GetMapping("/redis/testReSubmitLock")
    @RpcApi(apiId = "6221f12e0a849a10a89f9f5a")
    @ReSubmitLock
    public CommonResult testReSubmitLock() {
        return CommonResult.success(Boolean.TRUE);
    }

    /**
     * 测试手动添加分布式锁
     *
     * @return
     */
    @GetMapping("/redis/distributeLockService_tryLock")
    @RpcApi(apiId = "6221f12e0a849a10a89f9f62")
    public CommonResult testDistributeLockServiceTryLock() {

        String lockKeyName = LockKeyGenerator.generateLockKey(RedisStudyLockKeyEnum.MIN_PRICE, "111");
        log.info("lockKeyName = [{}]", lockKeyName);
        boolean flag = distributedLockManager.lock(lockKeyName, 6, TimeUnit.SECONDS);
        log.info("获取锁的结果 = {}", flag);
        if (!flag) {
            return CommonResult.fail(GlobalErrorCodeEnum.NOT_GET_LOCK);
        }
        try {
            System.out.println("开始执行业务逻辑");
        } finally {
            distributedLockManager.unlock(lockKeyName);
        }

        return CommonResult.success(true);
    }


}
