package com.jf.redisstudy.controller;

import com.jf.common.aspect.log.MethodLogger;
import com.jf.model.result.CommonResult;
import com.jf.redisstudy.domain.enums.RedisStudyCacheKeyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ConvertingCursor;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
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
public class ScanController {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询所有的都是这个前缀开头的key
     */
    @GetMapping("/scanAllByKeyPrefix")
    @MethodLogger(apiId = "6221f12e0a849a10a89f111")
    public CommonResult scanAllByKeyPrefix() {
        //需要匹配的key
        String patternKey = RedisStudyCacheKeyEnum.MIN_PRICE.getServiceName() + ":" + RedisStudyCacheKeyEnum.MIN_PRICE;
        List<String> cacheKeyList = scanAllByPattenKey(patternKey);
        return CommonResult.success(cacheKeyList);
    }

    /**
     * 从redis里面查询库存不一致的节目
     */
    @SuppressWarnings("all")
    public List<String> scanAllByPattenKey(String patternKey) {
        long start = System.currentTimeMillis();
        ScanOptions options = ScanOptions.scanOptions().count(10000).match(patternKey + "*").build();
        RedisSerializer<String> redisSerializer = (RedisSerializer<String>) redisTemplate.getKeySerializer();
        Cursor cursor = (Cursor) redisTemplate.executeWithStickyConnection(redisConnection -> new ConvertingCursor<>(redisConnection.scan(options), redisSerializer::deserialize));
        List<String> cacheKeyList = new ArrayList<>();
        while (true) {
            if (!cursor.hasNext()) break;
            cacheKeyList.add(cursor.next().toString());
        }
        try {
            cursor.close();
        } catch (IOException e) {
            log.error("redis scan error,错误原因：", e);
        }
        log.info("scan扫描共耗时：{} ms key数量：{}", System.currentTimeMillis() - start, cacheKeyList.size());

        return cacheKeyList;
    }
}