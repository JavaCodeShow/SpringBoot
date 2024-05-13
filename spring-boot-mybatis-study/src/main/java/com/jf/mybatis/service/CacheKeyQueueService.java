package com.jf.mybatis.service;

import com.jf.common.redis.manager.cache.DistributedCacheManager;
import com.jf.common.utils.id.IdGenerator;
import com.jf.mybatis.domain.entity.CacheKeyQueueEntity;
import com.jf.mybatis.mapper.CacheKeyQueueMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.time.LocalDateTime;

@Service
@Slf4j
public class CacheKeyQueueService {

    @Autowired
    private CacheKeyQueueMapper cacheKeyQueueMapper;

    @Autowired
    private DistributedCacheManager distributedCacheManager;

    public int insert(CacheKeyQueueEntity entity) {
        return cacheKeyQueueMapper.insert(entity);
    }

    public CacheKeyQueueEntity selectByPrimaryKey(String id) {
        return cacheKeyQueueMapper.selectByPrimaryKey(id);

    }

    public int updateByPrimaryKey(CacheKeyQueueEntity entity) {
        return cacheKeyQueueMapper.updateByPrimaryKey(entity);
    }


    /**
     * 保证缓存和数据的强一致性，修改DB数据后需要删除缓存。
     */
    public void syncDeleteCache(String cacheKeyId) {
        String cacheKeyQueueId = IdGenerator.generateId();
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {

            @Override
            public void beforeCommit(boolean flag) {
                insertCacheKeyQueue(cacheKeyQueueId, cacheKeyId);
            }

            @Override
            public void afterCommit() {
                delCacheAndDeleteCacheKeyQueue(cacheKeyId, cacheKeyQueueId);
            }

            @Override
            public void afterCompletion(int status) {
                // 锁的释放处理
                log.info("事务完成(提交或回滚)后处理,status={}", status);
            }
        });
    }

    /**
     * 插入cache_key_queue记录
     */
    private void insertCacheKeyQueue(String cacheKeyQueueId, String cacheKeyId) {
        CacheKeyQueueEntity cacheKeyQueueEntity = new CacheKeyQueueEntity();
        cacheKeyQueueEntity.setId(cacheKeyQueueId);
        cacheKeyQueueEntity.setCacheKey(cacheKeyId);
        cacheKeyQueueEntity.setCreateTime(LocalDateTime.now());
        cacheKeyQueueMapper.insert(cacheKeyQueueEntity);
        log.info("事务提交前,插入cache_key_queue记录成功，cacheKeyQueueId={}", cacheKeyQueueId);
    }

    /**
     * 同步删除缓存，若删除缓存成功则同步删除cache_key_queue表记录
     */
    private void delCacheAndDeleteCacheKeyQueue(String cacheKeyId, String cacheKeyQueueId) {
        // todo 这里需要延迟双删
        distributedCacheManager.del(cacheKeyId);
        cacheKeyQueueMapper.logicDeleteById(cacheKeyQueueId);
        log.info("事务提交后,删除缓存成功");
        log.info("事务提交后,删除cache_key_queue记录成功，cacheKeyQueueId={}", cacheKeyQueueId);
    }
}
