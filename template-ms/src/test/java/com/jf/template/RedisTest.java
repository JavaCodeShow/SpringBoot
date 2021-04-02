package com.jf.template;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import com.jf.common.redis.service.RedisService;
import com.jf.common.redis.service.RedissonLockService;
import com.jf.common.utils.utils.time.LocalDateTimeUtil;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-03-24 11:07
 * @since: 2.22.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

	@Autowired
	private RedissonClient redissonClient;

	@Autowired
	private RedisService redisService;

	@Autowired
	private RedissonLockService redissonLockService;

	@Autowired
	@Qualifier("baseAsyncExecutor")
	private ThreadPoolTaskExecutor baseAsyncExecutor;

	/**
	 * 使用redissonClient 也可以操作redis的五大数据类型进行操作，<br>
	 * 但是比较麻烦。直接使用 StringRedisTemplate/RedisTemplate操作即可。 两者不冲突
	 */

	@Test
	public void testRedis() {
		// 插入 字符串
		RBucket<String> keyObj = redissonClient.getBucket("keyStr");
		keyObj.set("testStr", 300l, TimeUnit.SECONDS);

		// 查询 字符串
		RBucket<String> keyGet = redissonClient.getBucket("keyStr");
		System.out.println("redisson   " + keyGet.get());

		System.out.println("redis    " + redisService.get("keyStr"));

	}

	@Test
	public void testTryLock() throws InterruptedException {
		int threadCount = 10;
		System.out.println("测试tryLock");
		CountDownLatch latch = new CountDownLatch(threadCount);
		for (int i = 0; i < threadCount; i++) {
			baseAsyncExecutor.execute(() -> {
				try {
					boolean success = redissonLockService.tryLock("name", 5, 10,
							TimeUnit.SECONDS);
					System.out.println(
							"线程名字 = " + Thread.currentThread().getName()
									+ "   getLock = " + success + "   time = "
									+ LocalDateTimeUtil.getLocalDateTimeStr());
					latch.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}

		latch.await();
		System.out.println("exit");
	}

	@Test
	public void testLock() {
		System.out.println("测试lock");

		// 默认过期时间是30秒钟
		redissonLockService.lock("name");

		System.out.println("exit");

	}

}
