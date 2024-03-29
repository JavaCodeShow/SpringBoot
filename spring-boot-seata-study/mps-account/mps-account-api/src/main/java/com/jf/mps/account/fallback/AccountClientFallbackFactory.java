package com.jf.mps.account.fallback;

import com.jf.model.enums.GlobalErrorCodeEnum;
import com.jf.model.request.GenericRequest;
import com.jf.model.request.IdRequest;
import com.jf.model.response.CommonResult;
import com.jf.mps.account.api.AccountApi;
import com.jf.mps.account.client.AccountClient;
import com.jf.mps.account.info.AccountInfo;
import com.jf.mps.account.param.AccountCreateOrUpdateParam;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 调用分布式Id服务，异常熔断处理
 *
 * @author 江峰
 * @date 2020/7/19 15:04
 */
@Component
@Slf4j
public class AccountClientFallbackFactory implements FallbackFactory<AccountApi> {

    @Override
    public AccountClient create(Throwable throwable) {
        return new AccountClient() {
            @Override
            public CommonResult<AccountInfo> findById(IdRequest request) {
                return CommonResult.fail(GlobalErrorCodeEnum.RPC_TIME_OUT.getCode(), GlobalErrorCodeEnum.RPC_TIME_OUT.getMessage());
            }

            @Override
            public CommonResult<String> createOrUpdate(GenericRequest<AccountCreateOrUpdateParam> request) {
                return CommonResult.fail(GlobalErrorCodeEnum.RPC_TIME_OUT.getCode(), GlobalErrorCodeEnum.RPC_TIME_OUT.getMessage());
            }

        };
    }
}