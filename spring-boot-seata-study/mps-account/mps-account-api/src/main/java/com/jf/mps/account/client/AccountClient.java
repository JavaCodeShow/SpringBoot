package com.jf.mps.account.client;

import com.jf.mps.account.api.AccountApi;
import com.jf.mps.account.fallback.AccountClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 分布式Id服务
 *
 * @author 江峰
 * @date 2020/7/19 15:02
 */
@FeignClient(name = "mps-account", fallbackFactory = AccountClientFallbackFactory.class)
public interface AccountClient extends AccountApi {

}