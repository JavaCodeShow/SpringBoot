package com.jf.redisstudy.config;

import com.jf.redisstudy.ka.RedisKeyArgv;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * created by whroid
 **/
@Component
@Slf4j
public class RedisStoreComponent {


    @Autowired
    private StringRedisTemplate redisTemplate;

    //****************************** script ****************************
    public <T> T execute(RedisScript<T> script, List<String> keys, String... args) {
        try {
            return redisTemplate.execute(script, keys, args);
        } catch (Exception e) {
            log.warn("execute: keys:{},args:{}", keys, args);
            throw e;
        }
    }

    public <T> T executeByKa(RedisScript<T> script, List<? extends RedisKeyArgv> redisKeyArgvs) {
        List<String> keys = new ArrayList<>();
        List<String> argvs = new ArrayList<>();
        redisKeyArgvs.forEach(ka -> {
            ImmutablePair<String, String> pair = ka.getKeyAndArgv();
            keys.add(pair.getKey());
            argvs.add(pair.getValue());
        });
        if (log.isDebugEnabled()) {
            String kv = redisKeyArgvs.stream().map(RedisKeyArgv::getKeyAndArgv).map(Object::toString).collect(Collectors.joining(" "));
            log.debug("executeByKa script:{},kv:{}", script.getSha1(), kv);
        }
        try {
            // 添加一个异常铺货，转成hotException 并且把请求抛出来；
            return redisTemplate.execute(script, keys, argvs.toArray(new String[0]));
        } catch (Exception e) {
            String kv = redisKeyArgvs.stream().map(RedisKeyArgv::getKeyAndArgv).map(Object::toString).collect(Collectors.joining(" "));
            log.error("脚本执行异常 executeByKa script:{},kv:{}", script.getSha1(), kv);
            throw e;
        }

    }
}
