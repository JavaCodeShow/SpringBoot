package com.jf.redisstudy.domain.enums;


import com.jf.common.redis.generator.CacheKeyType;
import com.jf.redisstudy.domain.constant.SystemConstant;

/**
 * @author 江峰
 * @create 2021-12-28 22:54:59
 */
public enum RedisStudyCacheKeyEnum implements CacheKeyType {

    MIN_PRICE(0, "MIN_PRICE", "最小价");

    private Integer code;
    private String name;
    private String desc;

    RedisStudyCacheKeyEnum(Integer code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String getPrefix() {
        return SystemConstant.SYSTEM_NAME;
    }

    @Override
    public String getBizType() {
        return this.name;
    }
}