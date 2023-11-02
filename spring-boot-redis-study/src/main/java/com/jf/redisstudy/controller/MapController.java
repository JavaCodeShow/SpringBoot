package com.jf.redisstudy.controller;

import com.alibaba.fastjson.JSON;
import com.jf.common.aspect.log.MethodLogger;
import com.jf.common.redis.manager.cache.DistributedCacheManager;
import com.jf.model.response.CommonResult;
import com.jf.redisstudy.domain.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    private DistributedCacheManager distributedCacheManager;

    /**
     * 往map里面批量插入数据
     */
    @GetMapping("/hmset")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f4b")
    public CommonResult hmset() {
        String key = "hash";
        Map<String, String> map = new HashMap<>();
        map.put("f1", JSON.toJSONString(UserDTO.getUserOne()));
        map.put("f2", JSON.toJSONString(UserDTO.getUserTwo()));
        distributedCacheManager.hMSet(key, map);
        return CommonResult.success(Boolean.TRUE);
    }

    /**
     * 往map里面查询数据
     */
    @GetMapping("/hGet")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f4e")
    public CommonResult<UserDTO> hGet() {
        String key = "hash";
        String str = distributedCacheManager.hGet(key, "f1");
        UserDTO userDTO = JSON.parseObject(str, UserDTO.class);
        return CommonResult.success(userDTO);
    }

    /**
     * 往map里面批量查询数据
     */
    @GetMapping("/hMGet")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f64")
    public CommonResult<List<UserDTO>> hMGet() {
        String key = "hash";
        List<String> stringList = Arrays.asList("f1", "f2");
        List<String> strings = distributedCacheManager.hMGet(key, stringList);
        List<UserDTO> userDTOList = strings.stream().map(s -> JSON.parseObject(s, UserDTO.class)).collect(Collectors.toList());
        return CommonResult.success(userDTOList);
    }
}
