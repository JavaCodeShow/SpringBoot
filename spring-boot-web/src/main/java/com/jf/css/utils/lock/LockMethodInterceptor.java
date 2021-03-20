package com.jf.css.utils.lock;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.jf.common.common.meta.ResultCodeEnum;
import com.jf.common.exception.ServiceException;
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

	@Around("@annotation(com.jf.css.utils.lock.CacheLock)")
	public Object interceptor(ProceedingJoinPoint pjp) throws Throwable {

		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();

		CacheLock lock = method.getAnnotation(CacheLock.class);

		final String lockKey = cacheKeyGenerator.getLockKey(pjp);
		log.info("redis lock key is [{}]", lockKey);
		String expireTimeStr = String
				.valueOf(System.currentTimeMillis() + (lock.expire() * 1000L));

		boolean remove = true;

		try {
			// 采用原生 API 来实现分布式锁
			final boolean success = remove = redisService.tryLock(lockKey,
					expireTimeStr, lock.expire());
			if (!success) {
				// 重复提交异常不删除key
				throw new ServiceException(ResultCodeEnum.RESUBMIT);
			}
			return pjp.proceed();

		} finally {
			// 在设定时间之后会自动解锁
			// if (remove) {
			// // 需要将value传过去，只能解自己的锁
			// redisService.unLock(lockKey, expireTimeStr);
			// log.info("un lock = [{}]", lockKey);
			// }
		}
	}
}
