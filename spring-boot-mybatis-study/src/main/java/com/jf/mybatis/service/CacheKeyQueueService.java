package com.jf.mybatis.service;

import com.jf.mybatis.domain.entity.CacheKeyQueueEntity;
import com.jf.mybatis.mapper.CacheKeyQueueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheKeyQueueService {

    @Autowired
    private CacheKeyQueueMapper cacheKeyQueueMapper;


    public int insert(CacheKeyQueueEntity entity) {
        return cacheKeyQueueMapper.insert(entity);
    }

    public CacheKeyQueueEntity selectByPrimaryKey(String id) {
        return cacheKeyQueueMapper.selectByPrimaryKey(id);

    }

    public int updateByPrimaryKey(CacheKeyQueueEntity entity) {
        return cacheKeyQueueMapper.updateByPrimaryKey(entity);
    }

}
