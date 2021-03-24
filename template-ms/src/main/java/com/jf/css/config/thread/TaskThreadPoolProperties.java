package com.jf.css.config.thread;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2020-12-14 10:56:01
 * @since
 */
@ConfigurationProperties(prefix = "task.pool")
@Getter
@Setter
public class TaskThreadPoolProperties {

	private int corePoolSize;

	private int maxPoolSize;

	private int keepAliveSeconds;

	private int queueCapacity;
}
