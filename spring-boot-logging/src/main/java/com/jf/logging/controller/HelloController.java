package com.jf.logging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 江峰
 * @create 2020-03-22   22:00
 */
@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping("/hello")
    public String hello() {
        logger.trace("trace日志");
        logger.debug("debug日志");
        logger.info("info 日志");
        logger.error("error日志");
        return "hello ljm";
    }
}
