package com.jf.redisstudy.controller;

import com.jf.common.utils.aspect.log.MethodLogger;
import com.jf.common.utils.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类作用描述
 *
 * @author 江峰
 * @since 2021/7/27
 */
public class MapController {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 往map里面批量查询数据
     *
     * @return
     */
    @GetMapping("/hmgst")
    @MethodLogger
    public BaseResult<List<String>> hmgst() {
        String key = "hash";
        List<String> stringList = Arrays.asList("f1", "f2");
        List<String> list = redisTemplate.opsForHash().multiGet(key, stringList);
        return BaseResult.success(list);
    }

    /**
     * 往map里面批量插入数据
     *
     * @return
     */
    @GetMapping("/hmset")
    @MethodLogger
    public BaseResult hmset() {
        String key = "hash";
        Map<String, String> map = new HashMap<>();
        map.put("f1", "val1");
        map.put("f2", "val2");
        redisTemplate.opsForHash().putAll(key, map);
        return BaseResult.success();
    }
}
