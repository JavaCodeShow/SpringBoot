package com.jf.redisstudy.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jf.common.aspect.log.RpcApi;
import com.jf.common.redis.manager.cache.DistributedCacheManager;
import com.jf.model.response.CommonResult;
import com.jf.redisstudy.domain.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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
    private DistributedCacheManager distributedCacheManager;

    /**
     * 插入数据
     */
    @GetMapping("/set")
    @RpcApi(apiId = "6221f12e0a849a10a89f9f4f")
    public CommonResult<Boolean> set() {

        UserDTO userOne = UserDTO.getUserOne();
        UserDTO userTwo = UserDTO.getUserTwo();
        distributedCacheManager.set("aaa", JSON.toJSONString(userOne));
        distributedCacheManager.set("bbb", JSON.toJSONString(userTwo));
        return CommonResult.success(Boolean.TRUE);
    }

    /**
     * 批量查询数据
     */
    @GetMapping("/mGet")
    @RpcApi(apiId = "6221f12e0a849a10a89f9f50")
    public CommonResult<List<UserDTO>> mGet() {

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("ccc");
        list.add("bbb");
        List<String> list1 = distributedCacheManager.mGet(list);
        log.info("list1={}", list1);
        List<UserDTO> userDTOList = list1.stream().map(s -> JSON.parseObject(s, UserDTO.class)).collect(Collectors.toList());
        String aaa = distributedCacheManager.getRedisTemplate().opsForValue().get("aaa");
        System.out.println(aaa);
        distributedCacheManager.hLen("user");
        distributedCacheManager.setNX("a","2");
        // String cacheKey = CacheKeyGenerator.getObjectCacheKey(RedisStudyCacheKeyEnum.MIN_PRICE, "111");
        // List<UserDTO> userDTOList = ConcurrentProtectedCacheUtils.get(cacheKey, UserDTO.class, UserDTO::getUserList);
        return CommonResult.success(userDTOList);
    }

    /**
     * 批量查询数据
     */
    @GetMapping("/get")
    @RpcApi(apiId = "6221f12e0a849a10a89f9f54")
    public CommonResult<UserDTO> get() {

        String aaa = distributedCacheManager.get("aaa");
        UserDTO userDTO = JSONObject.parseObject(aaa, UserDTO.class);
        fun();
        return CommonResult.success(userDTO);
    }

    void fun() {
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}