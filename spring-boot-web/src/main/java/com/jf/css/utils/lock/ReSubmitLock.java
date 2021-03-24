package com.jf.css.utils.lock;

import java.lang.annotation.*;

import com.jf.css.common.constant.CommonConstant;

/**
 * 防重复提交
 *
 * @author 江峰
 * @date 2020/6/19 11:47 上午
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ReSubmitLock {

	/**
	 * redis 锁key的前缀
	 *
	 * @return redis 锁key的前缀
	 */
	String prefix() default CommonConstant.SYSTEM_CODE;

	/**
	 * 持有该锁的时间 <br>
	 * 默认10秒钟客户端没有主动解锁，则主动释放锁
	 */
	int leaseTime() default 10;

	/**
	 * <p>
	 * Key的分隔符（默认 :）
	 * </p>
	 * <p>
	 * 生成的Key：N:SO1008:500
	 * </p>
	 *
	 * @return String
	 */
	String delimiter() default ":";
}
