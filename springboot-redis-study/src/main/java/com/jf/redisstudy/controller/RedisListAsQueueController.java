package com.jf.redisstudy.controller;

import com.jf.common.utils.aspect.log.MethodLogger;
import com.jf.common.utils.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述: redis list 作为阻塞队列
 *
 * @author: 江峰
 * @create: 2021-05-21 15:08
 * @since: 2.20.1.1
 */
@RestController
@Slf4j
public class RedisListAsQueueController {

    @Autowired
    private RedisTemplate redisTemplate;

    static int count = 0;

    @RequestMapping("/redis_queue_push")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f53")
    public BaseResult redisQueuePush() {
        redisTemplate.opsForList().leftPush("list", "hello" + count);
        return BaseResult.success();
    }

}
