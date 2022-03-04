package com.jf.template.controller;

import com.jf.common.redis.annotation.DistributeLock;
import com.jf.common.redis.annotation.ReSubmitLock;
import com.jf.common.utils.aspect.log.MethodLogger;
import com.jf.common.utils.result.BaseResult;
import com.jf.template.domain.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-03-23 18:55
 * @since: 2.22.1
 */
@RestController
@RequestMapping
@Slf4j
public class RedisTestController {

    @Autowired
    @Qualifier("baseAsyncExecutor")
    private Executor baseAsyncExecutor;

    @GetMapping(value = "/redis/testDistributeLock")
    @MethodLogger(apiId = "6221ec540a849a4ef44d38ff")
    @DistributeLock(lockKey = "orderId")
    public BaseResult testDistributeLock() {

        System.out.println("执行相关业务...");
        System.out.println("执行相关业务.....");
        System.out.println("执行相关业务......");

        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return BaseResult.success();
    }

    /**
     * 测试防止重复提交
     */
    @GetMapping("/redis/testReSubmitLock")
    @MethodLogger(apiId = "6221ec540a849a4ef44d3900")
    @ReSubmitLock
    public BaseResult<OrderDTO> testReSubmitLock() {

        OrderDTO order = OrderDTO.builder().id(1).orderId(111).name("秀儿，是你吗")
                .build();
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return BaseResult.success(order);
    }

}
