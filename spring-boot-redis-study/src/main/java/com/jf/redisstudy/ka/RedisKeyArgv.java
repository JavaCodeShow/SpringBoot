package com.jf.redisstudy.ka;

import org.apache.commons.lang3.tuple.ImmutablePair;

/**
 * created by whroid
 **/
public interface RedisKeyArgv {

    ImmutablePair<String, String> getKeyAndArgv();

    /**
     * 处理返回值
     *
     * @param retvalue
     * @return
     */
    boolean handleReturn(Object retvalue);

    String getErrorMsg();

}
