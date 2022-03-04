package com.jf.redisstudy.controller;

import com.alibaba.fastjson.JSON;
import com.jf.common.redis.service.cache.GlobalCacheService;
import com.jf.common.utils.aspect.log.MethodLogger;
import com.jf.common.utils.result.BaseResult;
import com.jf.redisstudy.domain.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 类作用描述
 *
 * @author 江峰
 * @since 2021/7/27
 */
@RestController
@Slf4j
public class MapController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private GlobalCacheService globalCacheService;

    /**
     * 往map里面批量插入数据
     */
    @GetMapping("/hmset")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f4b")
    public BaseResult hmset() {
        String key = "hash";
        Map<String, String> map = new HashMap<>();
        map.put("f1", JSON.toJSONString(UserDTO.getOneUser()));
        globalCacheService.hMSet(key, map);
        return BaseResult.success();
    }


    /**
     * 往map里面查询数据
     */
    @GetMapping("/hGet")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f4e")
    public BaseResult hGet() {
        String key = "hash";
        String str = globalCacheService.hGet(key, "f1");
        UserDTO userDTO = JSON.parseObject(str, UserDTO.class);
        return BaseResult.success(userDTO);
    }

    /**
     * 往map里面批量查询数据
     */
    @GetMapping("/hMGet")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f64")
    public BaseResult hMGet() {
        String key = "hash";
        List<String> stringList = Arrays.asList("f1", "f2");
        // List<String> list = redisTemplate.opsForHash().multiGet(key, stringList);
        List<String> strings = globalCacheService.hMGet(key, stringList);
        List<UserDTO> userDTOList = strings.stream().map(s -> JSON.parseObject(s, UserDTO.class)).collect(Collectors.toList());
        return BaseResult.success(userDTOList);
    }
}
