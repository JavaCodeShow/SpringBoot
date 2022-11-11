package com.jf.redisstudy.controller;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CachePenetrationProtect;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.jf.model.result.CommonResult;
import com.alicp.jetcache.anno.CreateCache;
import com.jf.redisstudy.domain.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
public class JetCacheController {

    @CreateCache(cacheType = CacheType.LOCAL, expire = 100)
    @CachePenetrationProtect
    private Cache<String, String> userCache;

    @GetMapping("/cacheTest")
    public BaseResult<List<UserDTO>> cacheTest() {
        String str = userCache.computeIfAbsent("111", s -> "333");
        log.info("从缓存中获取结果：{}", str);
        userCache.put("111", "222");
        str = userCache.get("111");
        log.info("从缓存中获取结果：{}", str);
        userCache.remove("111");
        return BaseResult.success(UserDTO.getUserList());
    }

    /**
     * 单个key
     */
    @PostMapping("/jetCacheGet")
    @Cached(cacheType = CacheType.LOCAL, expire = 6)
    public CommonResult<List<UserDTO>> jetCacheGet(@RequestBody String bizShowId) {
        log.info("从数据库获得数据");
        return CommonResult.success(UserDTO.getUserList());
    }

    /**
     * 对象
     */
    @PostMapping("/jetCacheGet2")
    @Cached(cacheType = CacheType.LOCAL, expire = 6)
    public CommonResult<List<UserDTO>> jetCacheGet2(@RequestBody UserDTO userDTO) {
        log.info("从数据库获得数据");
        return CommonResult.success(UserDTO.getUserList());
    }

    /**
     * 集合排序
     */
    @PostMapping("/jetCacheGet3")
    @Cached(cacheType = CacheType.LOCAL, key = "T(com.jf.common.utils.jetcache.JetCacheUtils).sorted(#bizShowIdList)", expire = 6)
    public CommonResult<List<UserDTO>> jetCacheGet3(@RequestBody List<String> bizShowIdList) {
        log.info("从数据库获得数据");
        return CommonResult.success(UserDTO.getUserList());
    }


    /**
     * 集合对象排序
     */
    @PostMapping("/jetCacheGet4")
    @Cached(cacheType = CacheType.LOCAL, key = "T(com.jf.common.utils.jetcache.JetCacheUtils).sorted(#UserDTO)", expire = 6)
    public CommonResult<List<UserDTO>> jetCacheGet4(@RequestBody List<UserDTO> userDTOList) {
        log.info("从数据库获得数据");
        return CommonResult.success(UserDTO.getUserList());
    }


}
