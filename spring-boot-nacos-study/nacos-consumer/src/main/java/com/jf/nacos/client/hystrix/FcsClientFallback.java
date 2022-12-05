package com.jf.nacos.client.hystrix;

import com.jf.model.enums.GlobalErrorCodeEnum;
import com.jf.model.result.CommonResult;
import com.jf.nacos.client.FcsClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 调用蜂羽主项目，异常熔断处理
 *
 * @author 江峰
 * @date 2020/7/19 15:04
 */
@Component
@Slf4j
public class FcsClientFallback implements FallbackFactory<FcsClient> {

    @Override
    public FcsClient create(Throwable throwable) {
        log.error("调用FCS失败：", throwable);
        return new FcsClient() {
            @Override
            public CommonResult getOrderById(Integer orderId) {

                return CommonResult.fail(GlobalErrorCodeEnum.SERVER_ERROR.getCode(),
                        "根据订单id查询订单失败");
            }

        };
    }
}