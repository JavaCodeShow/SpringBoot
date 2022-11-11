package com.jf.mybatis.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 缓存删除队列表
 *
 * @TableName cache_key_queue
 */
public class CacheKeyQueueEntity implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 待删除的缓存key
     */
    private String cacheKey;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 待删除的缓存key
     */
    public String getCacheKey() {
        return cacheKey;
    }

    /**
     * 待删除的缓存key
     */
    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }

    /**
     * 创建时间
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}