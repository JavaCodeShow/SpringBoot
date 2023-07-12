package com.jf.redisstudy.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DynamicLoggersConfig {

    Logger logger = LoggerFactory.getLogger(getClass());

    private final static String LoggerTag = "logging.level.";

    @ApolloConfig
    private Config config;

    @Autowired
    private LoggingSystem loggingSystem;

    /**
     * logging.level.com.jf = warn
     */
    @ApolloConfigChangeListener
    private void configChangeListener(ConfigChangeEvent changeEvent) {
        Set<String> keyNames = config.getPropertyNames();
        for (String key : keyNames) {
            if (StringUtils.containsIgnoreCase(key, LoggerTag)) {
                String strLevel = config.getProperty(key, "info");
                LogLevel level = LogLevel.valueOf(strLevel.toUpperCase());
                loggingSystem.setLogLevel(key.replace(LoggerTag, ""), level);
                logger.info("{}:{}", key, strLevel);
            }
        }
    }
}