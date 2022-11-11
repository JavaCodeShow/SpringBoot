package com.jf.redisstudy.controller;

import com.jf.common.aspect.log.MethodLogger;
import com.jf.model.result.CommonResult;
import com.jf.redisstudy.config.RedisStoreComponent;
import com.jf.redisstudy.ka.DefaultHashKa;
import com.jf.redisstudy.lua.CacheConsts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class LuaController {

    @Autowired
    private RedisStoreComponent redisTemplate;

    @Autowired
    @Qualifier(CacheConsts.LUA_BATCH_DELTA_NUM)
    public DefaultRedisScript<String> batchDeltaNumScript;

    @RequestMapping("/batchDeltaNum")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f52")
    public CommonResult<String> batchDeltaNum() {
        List<String> keyList = new ArrayList<>();
        keyList.add("k1");
        keyList.add("k2");
        List<String> numList = new ArrayList<>();
        numList.add("1");
        numList.add("1");
        String execute = redisTemplate.execute(batchDeltaNumScript, keyList, numList.toArray(new String[0]));
        return CommonResult.success("hello springboot-redis");
    }

    @RequestMapping("/batchDeltaNum1")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f52")
    public CommonResult<String> batchDeltaNum1() {

        String script1 = "if redis.call('setnx', KEYS[1], ARGV[1]) == 1 then redis.call('set', KEYS[2], ARGV[2]) return 1 else return 0 end";
        Long result1 = (Long) redisTemplate.execute(
                new DefaultRedisScript<Long>(script1, Long.class),
                Arrays.asList("key1", "key2"),
                "value1", "value2"
        );
        System.out.println(result1); // 1

        // 如果key1==value1，则删除key1，返回删除的状态，否则返回0
        String script2 = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Long result2 = (Long) redisTemplate.execute(
                new DefaultRedisScript<Long>(script2, Long.class),
                Arrays.asList("key1"),
                "value1"
        );
        System.out.println(result2); // 1
        return CommonResult.success("hello springboot-redis");
    }

    public void batchIncrNum(List<Object> deleteTicketStockParams) {
        // List<DefaultHashKa> defaultHashKas = deleteTicketStockParams.stream().map(param -> DefaultHashKa.of("111", param.getDeleteStockId(), param.getTargetStockId())).collect(Collectors.toList());
        List<DefaultHashKa> defaultHashKas = new ArrayList<>();
        redisTemplate.executeByKa(batchDeltaNumScript, defaultHashKas);
    }

}
