package com.jf.mybatis.interceptor;

import java.lang.reflect.Method;
import java.util.Properties;

import com.jf.mybatis.mapper.AccountMapper;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-06-04 13:52
 * @since: 2.20.1.1
 */
@Intercepts({
		@Signature(type = AccountMapper.class, method = "getAccountById", args = {
				Integer.class }) })
public class TestInterceptor implements Interceptor {

	/**
	 * 拦截目标对象的目标方法执行
	 *
	 * @param invocation
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// 被代理对象
		Object target = invocation.getTarget();
		// 代理方法
		Method method = invocation.getMethod();
		// 方法参数
		Object[] args = invocation.getArgs();
		// do something ...... 方法拦截前执行代码块
		// 执行原来方法
		Object result = invocation.proceed();
		// do something .......方法拦截后执行代码块
		return result;
	}

	/**
	 * 包装目标对象：为目标对象创建代理对象
	 *
	 * @param target
	 * @return
	 */
	@Override
	public Object plugin(Object target) {
		System.out.println("MySecondPlugin为目标对象" + target + "创建代理对象");
		// this表示当前拦截器，target表示目标对象，wrap方法利用mybatis封装的方法为目标对象创建代理对象（没有拦截的对象会直接返回，不会创建代理对象）
		Object wrap = Plugin.wrap(target, this);
		return wrap;
	}

	/**
	 * 设置插件在配置文件中配置的参数值
	 *
	 * @param properties
	 */
	@Override
	public void setProperties(Properties properties) {
		System.out.println(properties);
	}
}
