package com.jf.css;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jf.css.service.redis.RedisService;

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

}
