package com.jf.css.client.hystrix;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jf.common.utils.meta.enums.ResultCodeEnum;
import com.jf.common.utils.result.BaseResult;
import com.jf.css.client.IdsClient;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * 调用分布式Id服务，异常熔断处理
 *
 * @author 江峰
 * @date 2020/7/19 15:04
 */
@Component
@Slf4j
public class IdsClientFallback implements FallbackFactory<IdsClient> {

	@Override
	public IdsClient create(Throwable throwable) {
		log.error("调用分布式Id服务失败：", throwable);
		return new IdsClient() {
			@Override
			public BaseResult<Long> getIds() {

				return BaseResult.fail(ResultCodeEnum.ERROR.getCode(),
						"获取一个id失败");

			}

			@Override
			public BaseResult<List<Long>> batchGetId(Integer count) {
				return BaseResult.fail(ResultCodeEnum.ERROR.getCode(),
						"批量获取id失败");

			}
		};
	}
}