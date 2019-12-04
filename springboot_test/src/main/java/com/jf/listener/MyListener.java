package com.jf.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author 潇潇暮雨
 * @create 2019-09-24   21:37
 */
public class MyListener implements ServletContextListener {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.debug("servletContextInit.....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.debug("servletContextDestroy.....");
    }
}
