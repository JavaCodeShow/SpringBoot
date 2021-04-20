package com.jf.redisstudy.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jf.common.redis.service.RedisService;
import com.jf.common.utils.aspect.log.MethodLogger;
import com.jf.common.utils.result.BaseResult;

import lombok.extern.slf4j.Slf4j;

/**
 * redis使用在单元测试里面
 *
 * @author 江峰
 * @create 2020-03-20 14:54
 */
@RestController
@Slf4j
public class HelloController {

	@Autowired
	RedisService redisService;
	@Autowired
	private RedisTemplate redisTemplate;

	@RequestMapping("/")
	@MethodLogger
	public String hello() {
		return "hello";
	}

	/**
	 * 往set里面批量插入数据
	 *
	 * @return
	 */
	@GetMapping("/batchSet")
	@MethodLogger
	public BaseResult batchSet() {

		String keyName = "zset2";
		for (int i = 0; i < 100; i++) {
			int count = 100000;
			int start = count * i;
			List<DefaultTypedTuple> list = new ArrayList<>();
			for (int j = start; j < count + start; j++) {
				DefaultTypedTuple<String> tuple1 = new DefaultTypedTuple<>(
						String.valueOf(j), (double) j);
				list.add(tuple1);
			}

			log.info("list.size = [{}]", list.size());

			redisTemplate.opsForZSet().add(keyName, new HashSet<>(list));

			Long size = redisTemplate.opsForZSet().size(keyName);

			log.info("size = [{}]", size);

		}

		return BaseResult.success();
	}

	/**
	 * 往set里面批量插入数据
	 *
	 * @return
	 */
	@GetMapping("/set")
	@MethodLogger
	public BaseResult set() {

		redisService.set("name", "江峰");

		return BaseResult.success();
	}

	/**
	 * 往set里面批量插入数据
	 *
	 * @return
	 */
	@GetMapping("/sinterstore")
	@MethodLogger
	public BaseResult<Set> sinterstore() {

		// Long size = redisTemplate.opsForZSet().intersectAndStore("zset1",
		// Collections.singleton("zset2"), "zset3",
		// RedisZSetCommands.Aggregate.MIN, RedisZSetCommands.Weights.of(1));
		List<String> keyNameList = new ArrayList<>();
		keyNameList.add("zset2");
		// keyNameList.add("zset4");
		Long size = redisTemplate.opsForZSet().intersectAndStore("zset1",
				"zset2", "zset3");

		log.info("size = [{}]", size);
		// Set zset3 = redisTemplate.opsForZSet().range("zset5", 0, -1);
		// System.out.println(zset3);
		return BaseResult.success(null);
	}

	/**
	 * 往set里面批量插入数据
	 *
	 * @return
	 */
	@GetMapping("/range")
	@MethodLogger
	public BaseResult<Set> range() {

		Set zset3 = redisTemplate.opsForZSet().range("zset3", 0, -1);

		return BaseResult.success(zset3);
	}

	/**
	 * 往set里面批量插入数据
	 *
	 * @return
	 */
	@GetMapping("/rangeWithScores")
	@MethodLogger
	public BaseResult<Set> rangeWithScores() {

		Set zset3 = redisTemplate.opsForZSet().rangeWithScores("zset3", 0, 10);

		return BaseResult.success(zset3);
	}

}
