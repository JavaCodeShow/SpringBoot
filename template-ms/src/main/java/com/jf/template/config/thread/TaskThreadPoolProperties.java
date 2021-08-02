package com.jf.template.config.thread;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2020-12-14 10:56:01
 * @since
 */
@ConfigurationProperties(prefix = "custom.task.pool")
@Getter
@Setter
public class TaskThreadPoolProperties {

    private int corePoolSize;

    private int maxPoolSize;

    private int keepAliveSeconds;

    private int queueCapacity;

    private String threadNamePrefix;

}
