package com.jf.sharding.jdbc;

import com.jf.common.utils.config.JfCommonUtilsConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author 江峰
 * @create 2020-03-21 10:56
 */
@SpringBootApplication
@Import({JfCommonUtilsConfig.class})
@MapperScan(basePackages = "com.jf.sharding.jdbc.mapper")
public class ShardingJdbcSpringBootMain {
    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcSpringBootMain.class, args);
    }
}
