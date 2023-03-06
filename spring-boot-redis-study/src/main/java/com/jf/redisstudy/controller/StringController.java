package com.jf.redisstudy.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jf.common.aspect.log.MethodLogger;
import com.jf.common.redis.generator.CacheKeyGenerator;
import com.jf.common.redis.manager.cache.CacheConcurrentProtectedUtils;
import com.jf.common.redis.manager.cache.GlobalCacheManager;
import com.jf.model.response.CommonResult;
import com.jf.redisstudy.domain.dto.UserDTO;
import com.jf.redisstudy.domain.enums.RedisStudyCacheKeyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private GlobalCacheManager globalCacheManager;

    /**
     * 插入数据
     */
    @GetMapping("/set")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f4f")
    public CommonResult set() {

        UserDTO userOne = UserDTO.getUserOne();
        UserDTO userTwo = UserDTO.getUserTwo();
        globalCacheManager.set("aaa", JSON.toJSONString(userOne));
        globalCacheManager.set("bbb", JSON.toJSONString(userTwo));
        for (int i = 0; i < 100; i++) {
            String cacheKey = CacheKeyGenerator.getCacheKey(RedisStudyCacheKeyEnum.MIN_PRICE, String.valueOf(i));
            globalCacheManager.set(cacheKey, String.valueOf(i));
        }
        return CommonResult.success(Boolean.TRUE);
    }

    /**
     * 批量查询数据
     */
    @GetMapping("/mGet")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f50")
    public CommonResult<List<UserDTO>> mGet() {

        // List<String> list = new ArrayList<>();
        // list.add("aaa");
        // list.add("bbb");
        // List<String> list1 = globalCacheManager.mGet(list);
        // List<UserDTO> userDTOList = list1.stream().map(s -> JSON.parseObject(s, UserDTO.class)).collect(Collectors.toList());

        String cacheKey = CacheKeyGenerator.getObjectCacheKey(RedisStudyCacheKeyEnum.MIN_PRICE, "111");
        List<UserDTO> userDTOList = CacheConcurrentProtectedUtils.get(cacheKey, UserDTO.class, UserDTO::getUserList);
        return CommonResult.success(userDTOList);
    }

    /**
     * 批量查询数据
     */
    @GetMapping("/get")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f54")
    public CommonResult<UserDTO> get() {

        String aaa = globalCacheManager.get("aaa");
        UserDTO userDTO = JSONObject.parseObject(aaa, UserDTO.class);
        return CommonResult.success(userDTO);
    }
}