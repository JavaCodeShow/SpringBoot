package com.jf.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 江峰
 * @create 2019-09-29   15:34
 */
@MapperScan(basePackages = "com.jf.mapper")
@Configuration
public class mybatisConfig {
}
