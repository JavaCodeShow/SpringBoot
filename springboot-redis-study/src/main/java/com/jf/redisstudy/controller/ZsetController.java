package com.jf.redisstudy.controller;

import com.jf.common.aspect.log.MethodLogger;
import com.jf.model.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 类作用描述
 *
 * @author 江峰
 * @since 2021/7/27
 */
@RestController
@Slf4j
public class ZsetController {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 往set里面批量插入数据
     *
     * @return
     */
    @GetMapping("/batchZset")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f56")
    public BaseResult batchZset() {

        String keyName = "zset1";
        for (int i = 0; i < 100; i++) {
            int count = 100000;
            int start = count * i;
            List<DefaultTypedTuple> list = new ArrayList<>();
            for (int j = start; j < count + start; j++) {
                DefaultTypedTuple<String> tuple1 = new DefaultTypedTuple<>(
                        String.valueOf(j), (double) j);
                list.add(tuple1);
            }

            log.info("list.size = [{}]", list.size());

            redisTemplate.opsForZSet().add(keyName, new HashSet<>(list));

            Long size = redisTemplate.opsForZSet().size(keyName);

            log.info("size = [{}]", size);

        }

        return BaseResult.success();
    }

    /**
     * 往set里面批量插入数据
     *
     * @return
     */
    @GetMapping("/sinterstore")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f58")
    public BaseResult<Set> sinterstore() {

        // Long size = redisTemplate.opsForZSet().intersectAndStore("zset1",
        // Collections.singleton("zset2"), "zset3",
        // RedisZSetCommands.Aggregate.MIN, RedisZSetCommands.Weights.of(1));
        List<String> keyNameList = new ArrayList<>();
        keyNameList.add("zset2");
        keyNameList.add("zset3");
        Long size = redisTemplate.opsForZSet().intersectAndStore("zset1",
                keyNameList, "zset4");

        log.info("size = [{}]", size);
        // Set zset3 = redisTemplate.opsForZSet().range("zset5", 0, -1);
        // System.out.println(zset3);
        return BaseResult.success(null);
    }

    /**
     * 范围查询
     *
     * @return
     */
    @GetMapping("/range")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f5e")
    public BaseResult<Set> range() {

        Set zset3 = redisTemplate.opsForZSet().range("zset3", 0, -1);

        return BaseResult.success(zset3);
    }

    /**
     * 范围查询，根据分数
     *
     * @return
     */
    @GetMapping("/rangeWithScores")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f60")
    public BaseResult<Set> rangeWithScores() {

        Set zset3 = redisTemplate.opsForZSet().rangeWithScores("zset3", 0, 10);

        return BaseResult.success(zset3);
    }


}
