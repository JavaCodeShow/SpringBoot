package com.jf.css.utils.lock;

import java.lang.reflect.Method;
import java.util.UUID;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.jf.common.common.meta.ResultCodeEnum;
import com.jf.common.exception.ServiceException;
import com.jf.common.utils.time.LocalDateTimeUtil;
import com.jf.css.service.RedisService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author luxinghui
 * @date 2019-05-23
 */
@Aspect
@Slf4j
@Component
public class LockMethodInterceptor {

	@Resource
	private CacheKeyGenerator cacheKeyGenerator;

	@Resource
	private RedisService redisService;

	@Around("@annotation(com.jf.css.utils.lock.ReSubmitLock)")
	public Object interceptor(ProceedingJoinPoint pjp) throws Throwable {

		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();

		ReSubmitLock lock = method.getAnnotation(ReSubmitLock.class);

		final String lockKey = cacheKeyGenerator.getLockKey(pjp);
		log.info("redis lock key is [{}]", lockKey);

		String lockValue = UUID.randomUUID().toString();

		// 采用原生 API 来实现分布式锁
		final boolean success = redisService.tryLock(lockKey, lockValue,
				lock.expire());

		if (!success) {
			// 重复提交异常不删除key
			throw new ServiceException(ResultCodeEnum.RESUBMIT);
		}

		log.info("success = [{}], 时间 = [{}]", success,
				LocalDateTimeUtil.getLocalDateTimeStr());

		return pjp.proceed();
	}
}
