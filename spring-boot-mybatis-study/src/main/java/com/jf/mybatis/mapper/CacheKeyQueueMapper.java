package com.jf.mybatis.mapper;


import com.jf.mybatis.domain.entity.CacheKeyQueueEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jiangfeng
 */
@Mapper
public interface CacheKeyQueueMapper {

    int insert(CacheKeyQueueEntity entity);

    CacheKeyQueueEntity selectByPrimaryKey(String id);

    int updateByPrimaryKey(CacheKeyQueueEntity entity);

    int deleteById(String id);

    int logicDeleteById(String cacheKeyQueueId);
}
