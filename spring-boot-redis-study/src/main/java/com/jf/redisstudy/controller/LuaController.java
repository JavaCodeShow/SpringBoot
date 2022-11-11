package com.jf.redisstudy.controller;

import com.jf.common.aspect.log.MethodLogger;
import com.jf.model.result.CommonResult;
import com.jf.redisstudy.config.RedisStoreComponent;
import com.jf.redisstudy.lua.CacheConsts;
import com.jf.redisstudy.lua.ka.DefaultHashKa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
        // normalExecute();
        return CommonResult.success("hello springboot-redis");
    }

    private void normalExecute() {
        List<String> keyList = new ArrayList<>();
        keyList.add("k1");
        keyList.add("k2");
        List<String> numList = new ArrayList<>();
        numList.add("1");
        numList.add("1");
        redisTemplate.execute(batchDeltaNumScript, keyList, numList.toArray(new String[0]));
    }

    public void batchIncrNum() {
        // List<DefaultHashKa> defaultHashKas = deleteTicketStockParams.stream().map(param -> DefaultHashKa.of("111", param.getDeleteStockId(), param.getTargetStockId())).collect(Collectors.toList());
        List<DefaultHashKa> defaultHashKas = new ArrayList<>();
        redisTemplate.executeByKa(batchDeltaNumScript, defaultHashKas);
    }

}
