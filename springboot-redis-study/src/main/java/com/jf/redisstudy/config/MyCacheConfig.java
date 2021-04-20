package com.jf.redisstudy.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author 潇潇暮雨
 * @create 2018-10-07   10:32
 */
@Configuration
public class MyCacheConfig {

	// @Bean
	// public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory
	// redisConnectionFactory) {
	// RedisTemplate<Object, Object> template = new RedisTemplate();
	// template.setConnectionFactory(redisConnectionFactory);
	// // 设置默认的序列化机制
	// StringRedisSerializer stringRedisSerializer = new
	// StringRedisSerializer();
	// template.setDefaultSerializer(stringRedisSerializer);
	// System.out.println("redisTemplate注入了");
	// return template;
	//
	// }
}
