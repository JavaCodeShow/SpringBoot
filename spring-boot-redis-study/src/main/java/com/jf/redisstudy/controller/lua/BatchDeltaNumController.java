package com.jf.redisstudy.controller.lua;

import com.jf.common.aspect.log.RpcApi;
import com.jf.model.response.CommonResult;
import com.jf.redisstudy.lua.CacheConsts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class BatchDeltaNumController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    @Qualifier(CacheConsts.LUA_BATCH_DELTA_NUM)
    public DefaultRedisScript<Object> batchDeltaNumScript;

    @RequestMapping("/batchDeltaNum")
    @RpcApi(apiId = "6221f12e0a849a10a89f0000")
    public CommonResult<String> batchDeltaNum() {
        List<String> keyList = new ArrayList<>();
        keyList.add("k1");
        keyList.add("k2");
        List<String> numList = new ArrayList<>();
        numList.add("1");
        numList.add("1");
        redisTemplate.execute(batchDeltaNumScript, keyList, numList.toArray(new String[0]));
        return CommonResult.success("hello springboot-redis");
    }

}
