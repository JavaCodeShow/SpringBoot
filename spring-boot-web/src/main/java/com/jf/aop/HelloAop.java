package com.jf.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author 江峰
 * @create 2020-04-01   22:33
 */
@Aspect
@Component
public class HelloAop {
    //@Before:  前置通知
    @Before("execution(* com.jf.prometheus.controller..*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toString();
        Object result = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method name:" + methodName + "--value:" + result);
    }
}
