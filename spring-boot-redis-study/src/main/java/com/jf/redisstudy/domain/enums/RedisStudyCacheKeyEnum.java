package com.jf.redisstudy.domain.enums;


import com.jf.common.redis.generator.CacheKeyType;
import com.jf.redisstudy.domain.constant.SystemConstant;

/**
 * @author 江峰
 * @create 2021-12-28 22:54:59
 */
public enum RedisStudyCacheKeyEnum implements CacheKeyType {

    MIN_PRICE("MIN_PRICE", "最小价");

    private String name;
    private String desc;

    RedisStudyCacheKeyEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String getServiceName() {
        return SystemConstant.SYSTEM_NAME;
    }

    @Override
    public String getBizType() {
        return this.name;
    }
}
