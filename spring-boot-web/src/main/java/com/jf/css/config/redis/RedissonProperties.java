package com.jf.css.config.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-03-24 13:42
 * @since: 2.22.1
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "spring.redisson")
public class RedissonProperties {

	private String address;

}
