package com.jf.template.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jf.common.utils.result.BaseResult;
import com.jf.template.client.hystrix.IdsClientFallback;

/**
 * 分布式Id服务
 *
 * @author 江峰
 * @date 2020/7/19 15:02
 */
@FeignClient(name = "distribute-id-ms", fallbackFactory = IdsClientFallback.class)
public interface IdsClient {

	/**
	 * 获取一个id
	 *
	 * @return
	 */
	@GetMapping(value = "/id")
	BaseResult<Long> getIds();

	/**
	 * 获取count个id
	 *
	 * @return
	 */
	@GetMapping(value = "/id/{count}")
	BaseResult<List<Long>> batchGetId(@PathVariable Integer count);

}