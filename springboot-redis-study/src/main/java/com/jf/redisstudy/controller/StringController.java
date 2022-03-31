package com.jf.redisstudy.controller;

import com.alibaba.fastjson.JSONObject;
import com.jf.common.redis.service.cache.GlobalCacheService;
import com.jf.common.utils.aspect.log.MethodLogger;
import com.jf.common.utils.result.BaseResult;
import com.jf.redisstudy.domain.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 类作用描述
 *
 * @author 江峰
 * @since 2021/7/27
 */
@RestController
@Slf4j
public class StringController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private GlobalCacheService globalCacheService;

    /**
     * 插入数据
     */
    @GetMapping("/set")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f4f")
    public BaseResult set() {

        // stringRedisTemplate.opsForValue().set("bbb", "222");
        UserDTO oneUser = UserDTO.getOneUser();
        // redisTemplate.opsForValue().set("aaa", oneUser);
        // globalCacheService.set("aaa", oneUser);
        return BaseResult.success();
    }

    /**
     * 批量查询数据
     */
    @GetMapping("/mGet")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f50")
    public BaseResult mGet() {

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        // List<UserDTO> stringList = redisTemplate.opsForValue().multiGet(list);
        List<String> list1 = globalCacheService.mGet(list);
        return BaseResult.success(list1);
    }

    /**
     * 批量查询数据
     */
    @GetMapping("/get")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f54")
    public BaseResult<UserDTO> get() {

        String aaa = globalCacheService.get("aaa");
        UserDTO userDTO = JSONObject.parseObject(aaa, UserDTO.class);
        return BaseResult.success(userDTO);
    }
}