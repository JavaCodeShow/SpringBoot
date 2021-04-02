package com.jf.template.controller;

import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jf.common.redis.lock.DistributeLock;
import com.jf.common.redis.lock.ReSubmitLock;
import com.jf.common.redis.service.RedisService;
import com.jf.common.utils.aspect.log.MethodLogger;
import com.jf.common.utils.result.BaseResult;
import com.jf.template.domain.dto.OrderDTO;

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

	@Autowired
	private RedisService redisService;

	@Autowired
	@Qualifier("baseAsyncExecutor")
	private Executor baseAsyncExecutor;

	@GetMapping("/secskill")
	public BaseResult secskill() {

		AtomicInteger productNum = new AtomicInteger(2);

		String lockValue = UUID.randomUUID().toString();
		int threadCount = 1000;
		AtomicInteger execThreadNum = new AtomicInteger(1);

		for (int i = 0; i < threadCount; i++) {
			baseAsyncExecutor.execute(() -> {
				log.info("第[{}]个线程", execThreadNum.getAndIncrement());
				try {
					boolean success = redisService.tryLock("productId",
							lockValue, 10);
					if (success && productNum.get() > 0) {
						productNum.decrementAndGet();
					}
					log.info("线程名字 = [{}], success = [{}], 剩余数量 = [{}]",
							Thread.currentThread().getName(), success,
							productNum);
				} finally {
					redisService.unLock("productId", lockValue);
				}
				if (execThreadNum.get() == 1000) {
					System.out.println("exit");
				}
			});
		}

		return BaseResult.success();
	}

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
