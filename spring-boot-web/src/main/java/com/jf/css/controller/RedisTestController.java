package com.jf.css.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jf.common.redis.lock.DistributeLock;
import com.jf.common.redis.lock.ReSubmitLock;
import com.jf.common.utils.aspect.log.MethodLogger;
import com.jf.common.utils.result.BaseResult;
import com.jf.css.domain.dto.OrderDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-03-23 18:55
 * @since: 2.22.1
 */
@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisTestController {

	@GetMapping(value = "/testDistributeLock")
	@MethodLogger
	@DistributeLock(lockKey = "orderId")
	public BaseResult testDistributeLock() {

		System.out.println("执行相关业务...");
		System.out.println("执行相关业务.....");
		System.out.println("执行相关业务......");

		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return BaseResult.success();
	}

	/**
	 * 测试防止重复提交
	 * 
	 * @return
	 */
	@GetMapping("/testReSubmitLock")
	@MethodLogger
	@ReSubmitLock
	public BaseResult<OrderDTO> testReSubmitLock() {

		OrderDTO order = OrderDTO.builder().id(1).orderId(111).name("秀儿，是你吗")
				.build();

		return BaseResult.success(order);
	}

}
