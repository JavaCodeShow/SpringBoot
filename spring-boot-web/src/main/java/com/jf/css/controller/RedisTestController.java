package com.jf.css.controller;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jf.common.utils.result.BaseResult;
import com.jf.css.utils.lock.DistributeLock;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-03-23 18:55
 * @since: 2.22.1
 */
@RestController
@Slf4j
public class RedisTestController {

	@Autowired
	private RedissonClient redissonClient;

	@GetMapping(value = "testLock")
	@DistributeLock(lockKey = "css:order:orderId")
	public BaseResult testLock() {

		System.out.println("执行相关业务...");
		System.out.println("执行相关业务.....");
		System.out.println("执行相关业务......");

		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return BaseResult.success();
	}

	@GetMapping("/testData")
	public void testData() {

		// 插入 字符串
		RBucket<String> keyObj = redissonClient.getBucket("keyStr");
		keyObj.set("testStr", 300l, TimeUnit.SECONDS);

		// 查询 字符串
		RBucket<String> keyGet = redissonClient.getBucket("keyStr");
		System.out.println(keyGet.get());

	}

}
