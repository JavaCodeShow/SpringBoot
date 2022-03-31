package com.jf.template.config.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

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

    /**
     * 该线程池是一个通用的线程池，该服务里面的所有需求都可以使用这个线程池
     *
     * @return {@link TaskExecutor}
     */
    @Bean("commonTaskExecutor")
    public TaskExecutor commonTaskExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // 配置核心线程数
        executor.setCorePoolSize(16);

        // 配置最大线程数
        executor.setMaxPoolSize(20);

        // 配置队列大小
        executor.setQueueCapacity(2000);

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
