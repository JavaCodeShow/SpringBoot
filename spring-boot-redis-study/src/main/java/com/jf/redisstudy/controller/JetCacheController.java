package com.jf.redisstudy.controller;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.jf.model.result.BaseResult;
import com.jf.redisstudy.domain.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
public class JetCacheController {

    @PostMapping("/jetCacheGet")
    @Cached(cacheType = CacheType.LOCAL, expire = 6)
    public BaseResult<List<UserDTO>> jetCacheGet(@RequestBody String bizShowId) {
        log.info("从数据库获得数据");
        return BaseResult.success(UserDTO.getUserList());
    }

    /**
     * 集合排序
     */
    @PostMapping("/jetCacheGet2")
    @Cached(cacheType = CacheType.LOCAL, key = "T(com.jf.common.utils.jetcache.JetCacheUtils).sorted(#bizShowIdList)", expire = 6)
    public BaseResult<List<UserDTO>> jetCacheGet2(@RequestBody List<String> bizShowIdList) {
        log.info("从数据库获得数据");
        return BaseResult.success(UserDTO.getUserList());
    }
}
