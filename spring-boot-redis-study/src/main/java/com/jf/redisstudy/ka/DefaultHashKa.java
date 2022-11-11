package com.jf.redisstudy.ka;

import org.apache.commons.lang3.tuple.ImmutablePair;

public class DefaultHashKa implements RedisKeyArgv {

    private String key;
    private String hashKey;
    private String hashValue;

    public static DefaultHashKa of(String key, String hashKey, String hashValue) {
        DefaultHashKa defaultKa = new DefaultHashKa();
        defaultKa.hashKey = hashKey;
        defaultKa.key = key;
        defaultKa.hashValue = hashValue;
        return defaultKa;
    }

    @Override
    public ImmutablePair<String, String> getKeyAndArgv() {
        return ImmutablePair.of(key, hashKey + "=" + hashValue);
    }

    @Override
    public String getErrorMsg() {
        return "错误KV：key=" + key + " ,hashKey=" + hashKey + " hashValue=" + hashValue;
    }

    @Override
    public boolean handleReturn(Object retvalue) {
        return false;
    }
}
