package com.jf.template.controller;

import com.jf.common.aspect.log.MethodLogger;
import com.jf.common.redis.annotation.ReSubmitLock;
import com.jf.model.result.CommonResult;
import com.jf.template.domain.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 描述:
 *
 */
@RestController
@RequestMapping
@Slf4j
public class RedisTestController {

    @GetMapping(value = "/redis/testDistributeLock")
    @MethodLogger(apiId = "6221ec540a849a4ef44d38ff")
    public CommonResult testDistributeLock() {

        System.out.println("执行相关业务...");
        System.out.println("执行相关业务.....");
        System.out.println("执行相关业务......");

        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return CommonResult.success();
    }

    /**
     * 测试防止重复提交
     */
    @GetMapping("/redis/testReSubmitLock")
    @MethodLogger(apiId = "6221ec540a849a4ef44d3900")
    @ReSubmitLock
    public CommonResult<OrderDTO> testReSubmitLock() {

        OrderDTO order = OrderDTO.builder().id(1).orderId(111).name("秀儿，是你吗")
                .build();
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return CommonResult.success(order);
    }

}
