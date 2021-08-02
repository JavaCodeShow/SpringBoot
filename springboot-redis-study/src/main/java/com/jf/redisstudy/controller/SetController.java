package com.jf.redisstudy.controller;

import com.jf.common.utils.aspect.log.MethodLogger;
import com.jf.common.utils.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * 类作用描述
 *
 * @author 江峰
 * @since 2021/7/27
 */
@RestController
@Slf4j
public class SetController {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 往set里面批量插入数据
     *
     * @return
     */
    @GetMapping("/sadd")
    @MethodLogger
    public BaseResult sadd() {

        Set<String> set = new HashSet<>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        String keyName = "set1";
        redisTemplate.opsForSet().add(keyName, set.toArray());
        Set<String> members = redisTemplate.opsForSet().members(keyName);
        log.info("members = {}", members);
        return BaseResult.success();
    }
}