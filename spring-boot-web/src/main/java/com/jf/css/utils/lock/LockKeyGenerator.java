package com.jf.css.utils.lock;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.jf.css.common.constant.CommonConstant;

/**
 * @author luxinghui
 * @date 2019-05-23
 */
@Component
public class LockKeyGenerator implements CacheKeyGenerator {

	@Override
	public String getLockKey(ProceedingJoinPoint pjp) {

		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();
		CacheLock lockAnnotation = method.getAnnotation(CacheLock.class);

		// TODO 同一个人同一个方法(userId 和userType需要取系统具体的值)
		return CommonConstant.SYSTEM_CODE + lockAnnotation.delimiter()
				+ "userId" + lockAnnotation.delimiter() + "userType"
				+ lockAnnotation.delimiter() + method.getName();
	}
}
