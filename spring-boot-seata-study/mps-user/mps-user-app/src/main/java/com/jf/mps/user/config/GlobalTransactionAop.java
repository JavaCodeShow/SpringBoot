// package com.jf.mps.user.config;
//
// import io.seata.core.context.RootContext;
// import io.seata.core.exception.TransactionException;
// import io.seata.tm.api.GlobalTransactionContext;
// import lombok.extern.slf4j.Slf4j;
// import org.apache.commons.lang3.StringUtils;
// import org.aspectj.lang.JoinPoint;
// import org.aspectj.lang.annotation.AfterThrowing;
// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Before;
// import org.aspectj.lang.annotation.Pointcut;
// import org.aspectj.lang.reflect.MethodSignature;
// import org.springframework.stereotype.Component;
//
// import java.lang.reflect.Method;
//
// /**
//  * 全局事务处理切面
//  *
//  * @author enbei
//  * @Date 2022/12/8
//  */
// @Aspect
// @Component
// @Slf4j
// public class GlobalTransactionAop {
//
//     @Pointcut("within(com.jf..*.controller..*)")
//     public void controllerAspect() {
//     }
//
//
//     // @Before("serviceAspect() && !@within(javax.websocket.server.ServerEndpoint)")
//     @Before("controllerAspect()")
//     public void before(JoinPoint joinPoint) throws TransactionException {
//         MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//         Method method = signature.getMethod();
//         // GlobalTransaction tx = GlobalTransactionContext.getCurrentOrCreate();
//         if (StringUtils.isNotEmpty(RootContext.getXID())) {
//             log.info("拦截到需要分布式事务的方法：{},分布式全局事务XID:{}", method.getName(), RootContext.getXID());
//         }
//     }
//
//     /**
//      * 用于解决全局异常处理导致的全局事务失效问题
//      */
//     //@AfterThrowing(throwing = "e", pointcut = "serviceAspect() && !@within(javax.websocket.server.ServerEndpoint)")
//     @AfterThrowing(throwing = "e", pointcut = "controllerAspect()")
//     public void doRecoveryActions(Throwable e) throws TransactionException {
//         if (StringUtils.isNotEmpty(RootContext.getXID())) {
//             log.info("分布式全局事务XID:{}", RootContext.getXID());
//             GlobalTransactionContext.reload(RootContext.getXID()).rollback();
//         }
//     }
// }
//
