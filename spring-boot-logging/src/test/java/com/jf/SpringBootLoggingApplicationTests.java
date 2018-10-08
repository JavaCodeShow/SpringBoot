package com.jf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootLoggingApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {
        // SpringBoot 的日志级别是按下面的顺序由低到高的。
        logger.trace("这是trace日志");
        logger.debug("这是debug日志");
        // 此时看控制台可以发现springBoot默认的是info级别
        logger.info("这是info日志");
        logger.warn("这是warn日志");
        logger.error("这是error日志");

    }

}
