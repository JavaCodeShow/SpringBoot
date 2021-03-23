package com.jf.css.utils.lock.redission.lock;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 描述: 分布式锁自定义注解
 *
 * @author: 江峰
 * @create: 2021-03-23 18:51
 * @since: 2.22.1
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedissonLockAnnotation {

	/**
	 * 指定组成分布式锁的key
	 */
	String lockRedisKey();

}