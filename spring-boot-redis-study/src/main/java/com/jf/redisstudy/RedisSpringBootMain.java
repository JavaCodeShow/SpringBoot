package com.jf.redisstudy;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.jf.common.utils.PropertyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author 江峰
 * @create 2020-03-21   10:56
 */
@ServletComponentScan("com.jf")
@SpringBootApplication
@Slf4j
@EnableMethodCache(basePackages = "com.jf")
@EnableCreateCacheAnnotation
public class RedisSpringBootMain {
    public static void main(String[] args) {
        try {
            PropertyRepository.initCenter("spring-redis-study.properties");
            PropertyRepository.initCenter("global.properties");
        } catch (Exception e) {
            log.error("服务启动加载配置文件失败，失败原因：", e);
            System.exit(0);
        }
        SpringApplication.run(RedisSpringBootMain.class, args);
    }
}
