package com.jf.css.config.thread;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2020-12-14 10:57:56
 * @since
 */

@EnableAsync // 开启异步任务支持，然后才能使用@Async注解（@Async 注解作用应该使用在方法上，表示这个方法是异步方法。）
@Configuration
@EnableConfigurationProperties({ TaskThreadPoolProperties.class })
@Slf4j
public class BaseThreadPoolConfig {

	@Autowired
	private TaskThreadPoolProperties threadPoolProperties;

	private static final String THREAD_NAME = "baseAsyncExecutor";

	@Bean(value = THREAD_NAME)
	public ThreadPoolTaskExecutor taskExecutor() {

		log.info("threadPoolProperties = [{}]",
				JSONObject.toJSONString(threadPoolProperties));

		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

		// 核心线程池大小
		executor.setCorePoolSize(threadPoolProperties.getCorePoolSize());

		// 最大线程数
		executor.setMaxPoolSize(threadPoolProperties.getMaxPoolSize());

		// 队列容量
		executor.setQueueCapacity(threadPoolProperties.getQueueCapacity());

		// 活跃时间
		executor.setKeepAliveSeconds(
				threadPoolProperties.getKeepAliveSeconds());

		// 线程名字前缀
		executor.setThreadNamePrefix("TaskExecutePool-");

		// setRejectedExecutionHandler：当pool已经达到max size的时候，如何处理新任务
		// CallerRunsPolicy：不在新线程中执行任务，而是由调用者所在的线程来执行
		executor.setRejectedExecutionHandler(
				new ThreadPoolExecutor.CallerRunsPolicy());

		// 等待所有任务结束后再关闭线程池
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.initialize();

		return executor;
	}
}
