package com.jf.mps.user.config;

import com.jf.common.trace.executor.MyThreadPoolTaskExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 *
 * @author 江峰
 * @since 2021/07/12
 */
@Configuration
@EnableAsync
public class ExecutorConfig {

    @Bean("commonTaskExecutor")
    public TaskExecutor commonTaskExecutor() {

        // 使用自定义的线程池，实现父子线程传递
        MyThreadPoolTaskExecutor executor = new MyThreadPoolTaskExecutor();

        // 配置核心线程数
        executor.setCorePoolSize(32);

        // 配置最大线程数
        executor.setMaxPoolSize(64);

        // 配置队列大小
        executor.setQueueCapacity(128);

        // 配置存活时间
        executor.setKeepAliveSeconds(60);

        // 配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("commonTaskExecutor-");

        // 配置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);

        // 初始化线程池
        executor.initialize();

        return executor;
    }

}
