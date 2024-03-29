package com.jf.redisstudy.controller;

import com.jf.common.aspect.log.RpcApi;
import com.jf.common.redis.manager.cache.DistributedCacheManager;
import com.jf.model.response.CommonResult;
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
public class ScanController {

    @Autowired
    private DistributedCacheManager distributedCacheManager;

    /**
     * 查询所有的都是这个前缀开头的key
     */
    @GetMapping("/scanAllByKeyPrefix")
    @RpcApi(apiId = "6221f12e0a849a10a89f111")
    public CommonResult scanAllByKeyPrefix() {
        //需要匹配的key
        String patternKey = RedisStudyCacheKeyEnum.MIN_PRICE.getServiceName() + ":" + RedisStudyCacheKeyEnum.MIN_PRICE;
        List<String> cacheKeyList = distributedCacheManager.scanAllByPattenKey(patternKey);
        return CommonResult.success(cacheKeyList);
    }


}