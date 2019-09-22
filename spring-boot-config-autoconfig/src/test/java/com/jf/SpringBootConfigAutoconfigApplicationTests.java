package com.jf;

import com.jf.bean.Dog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootConfigAutoconfigApplicationTests {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ApplicationContext ac;

    @Test
    public void log() {
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.error("error");

    }
    @Test
    public void contextLoads() {
        System.out.println(ac.containsBean("dog"));
    }

}
