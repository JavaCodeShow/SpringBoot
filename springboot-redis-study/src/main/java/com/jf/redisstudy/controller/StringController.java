package com.jf.redisstudy.controller;

import com.jf.common.redis.service.cache.GlobalCacheService;
import com.jf.common.utils.aspect.log.MethodLogger;
import com.jf.common.utils.result.BaseResult;
import com.jf.redisstudy.domain.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
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
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private GlobalCacheService globalCacheService;

    /**
     * 插入数据
     *
     * @return
     */
    @GetMapping("/set")
    @MethodLogger
    public BaseResult set() {

        // stringRedisTemplate.opsForValue().set("bbb", "222");
        UserDTO oneUser = UserDTO.getOneUser();
        stringRedisTemplate.opsForValue().set("aaa", String.valueOf(oneUser));
        // globalCacheService.set("aaa", JSON.toJSONString(oneUser));
        return BaseResult.success();
    }


    /**
     * 批量查询数据
     *
     * @return
     */
    @GetMapping("/multi_Get")
    @MethodLogger
    public BaseResult multiGet() {

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        List<String> stringList = stringRedisTemplate.opsForValue().multiGet(list);
        log.info("stringList = " + stringList);
        return BaseResult.success(stringList);
    }


}