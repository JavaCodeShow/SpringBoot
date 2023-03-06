package com.jf.mps.user.client;

import com.jf.mps.user.api.UserApi;
import com.jf.mps.user.fallback.UserClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 分布式Id服务
 *
 * @author 江峰
 * @date 2020/7/19 15:02
 */
@FeignClient(name = "mps-user", fallbackFactory = UserClientFallbackFactory.class)
public interface UserClient extends UserApi {

}