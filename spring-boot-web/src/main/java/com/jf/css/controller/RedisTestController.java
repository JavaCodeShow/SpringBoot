package com.jf.css.controller;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.jf.css.utils.lock.redission.lock.RedissonLockAnnotation;

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

	@PostMapping(value = "testLock", consumes = "application/json")
	@RedissonLockAnnotation(lockRedisKey = "productName,platFormName")
	public String testLock(@RequestBody JSONObject params) {

		/**
		 * 分布式锁key=params.getString("productName")+params.getString("platFormName");
		 * productName 产品名称 platFormName 平台名称 如果都一致,那么分布式锁的key就会一直,那么就能避免并发问题
		 */
		// TODO 业务处理

		System.out.println("接收到的参数：" + params.toString());
		System.out.println("执行相关业务...");
		System.out.println("执行相关业务.....");

		System.out.println("执行相关业务......");

		return "success";
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
