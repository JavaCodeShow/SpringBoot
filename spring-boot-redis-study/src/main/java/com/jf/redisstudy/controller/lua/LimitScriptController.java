package com.jf.redisstudy.controller.lua;

import com.jf.common.aspect.log.MethodLogger;
import com.jf.model.result.CommonResult;
import com.jf.redisstudy.config.RedisStoreComponent;
import com.jf.redisstudy.lua.CacheConsts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class LimitScriptController {

    @Autowired
    private RedisStoreComponent redisStoreComponent;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    @Qualifier(CacheConsts.LUA_BATCH_DELTA_NUM)
    public DefaultRedisScript<Object> batchDeltaNumScript;

    @Autowired
    @Qualifier(CacheConsts.LUA_LIMIT)
    public DefaultRedisScript<Object> limitScript;

    @RequestMapping("/limit")
    @MethodLogger(apiId = "6221f12e0a849a10a89f1111")
    public CommonResult<String> limit() {
        // Object result1 = limit1();
        Object result2 = limit2();
        log.info("result2 = {}", result2);
        log.info("result2 = {}", result2);
        log.info("result2 = {}", result2);
        log.info("result2 = {}", result2);
        return CommonResult.success("hello springboot-redis");
    }

    private Object limit1() {
        List<String> list = new ArrayList<>();
        list.add("door");
        //定义 keys,argv和result序列化方式
        //控制每60秒的访问频率为5次
        Object result = redisTemplate.execute(limitScript, new StringRedisSerializer(), new StringRedisSerializer(), list, "60", "5");
        return result;
    }

    private Object limit2() {
        RedisScript redisScript = RedisScript.of("local times = redis.call('incr',KEYS[1]) if times == 1 then redis.call('expire',KEYS[1],ARGV[1]) end if times > tonumber(ARGV[2]) then return 0 end return 1",
                Long.class);//注意是Long类型,而不是Integer
        List<String> list = new ArrayList<>();
        list.add("door3");
        Object result = redisTemplate.execute(redisScript, new StringRedisSerializer(), new StringRedisSerializer(), list, "60", "5");
        return result;
    }

}
