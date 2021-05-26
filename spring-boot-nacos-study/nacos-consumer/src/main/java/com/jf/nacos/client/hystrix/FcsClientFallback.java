package com.jf.nacos.client.hystrix;

import org.springframework.stereotype.Component;

import com.jf.common.utils.meta.enums.ResultCodeEnum;
import com.jf.common.utils.result.BaseResult;
import com.jf.nacos.client.FcsClient;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

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
			public BaseResult getOrderById(Integer orderId) {

				return BaseResult.fail(ResultCodeEnum.ERROR.getCode(),
						"根据订单id查询订单失败");
			}

		};
	}
}