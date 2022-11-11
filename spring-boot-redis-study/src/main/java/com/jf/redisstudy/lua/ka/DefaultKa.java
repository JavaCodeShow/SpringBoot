package com.jf.redisstudy.lua.ka;

import org.apache.commons.lang3.tuple.ImmutablePair;

public class DefaultKa implements RedisKeyArgv {

    private String key;
    private String argv;

    public static DefaultKa of(String key, String argv) {
        DefaultKa defaultKa = new DefaultKa();
        defaultKa.argv = argv;
        defaultKa.key = key;
        return defaultKa;
    }

    @Override
    public ImmutablePair<String, String> getKeyAndArgv() {
        return ImmutablePair.of(key, argv);
    }

    @Override
    public String getErrorMsg() {
        return "错误KV：key=" + key + " ,argv=" + argv;
    }

    @Override
    public boolean handleReturn(Object retvalue) {
        return false;
    }
}
