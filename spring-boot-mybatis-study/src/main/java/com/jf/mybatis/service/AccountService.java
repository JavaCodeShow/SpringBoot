package com.jf.mybatis.service;

import com.alibaba.fastjson.JSONObject;
import com.jf.common.redis.manager.cache.GlobalCacheManager;
import com.jf.common.utils.ParamChecker;
import com.jf.common.utils.id.IdGenerator;
import com.jf.mybatis.domain.entity.AccountEntity;
import com.jf.mybatis.domain.entity.CacheKeyQueueEntity;
import com.jf.mybatis.domain.param.account.AccountCreateParam;
import com.jf.mybatis.domain.param.account.AccountUpdateParam;
import com.jf.mybatis.mapper.AccountMapper;
import com.jf.mybatis.mapper.CacheKeyQueueMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.time.LocalDateTime;

/**
 * @author 江峰
 */
@Service
@Slf4j
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private CacheKeyQueueMapper cacheKeyQueueMapper;

    @Autowired
    private GlobalCacheManager globalCacheManager;

    public AccountEntity getAccountById(String id) {
        String value = globalCacheManager.get(id);
        if (StringUtils.isNotBlank(value)) {
            return JSONObject.parseObject(value, AccountEntity.class);
        }
        AccountEntity accountEntity = accountMapper.findById(id);
        globalCacheManager.set(id, JSONObject.toJSONString(accountEntity));
        return accountEntity;
    }

    /**
     * 账户一向账户二转money。
     */
    @Transactional(rollbackFor = Exception.class)
    public void transAccount(AccountEntity accountEntity1,
                             AccountEntity accountEntity2,
                             Integer money) {
        accountEntity1.setMoney(accountEntity1.getMoney() - money);
        accountEntity2.setMoney(accountEntity2.getMoney() + money);
        accountMapper.updateMoneyById(accountEntity1);
        accountMapper.updateMoneyById(accountEntity2);

        // 手动异常
        // throw new IllegalArgumentException("出异常了，数据将回滚" + accountMapper.getAccountById(1));

    }

    public Integer createAccount(AccountCreateParam param) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(param.getId());
        accountEntity.setMoney(param.getMoney());
        accountEntity.setName(param.getName());
        accountMapper.insert(accountEntity);
        return accountEntity.getId();
    }

    @Transactional
    public void updateAccount(AccountUpdateParam param) {

        AccountEntity accountEntity = accountMapper.findById(param.getId());
        ParamChecker.notNull(accountEntity, "账户不能为空");
        accountEntity.setName(param.getName());
        accountEntity.setMoney(param.getMoney());
        accountMapper.update(accountEntity);

        syncDeleteCache(param.getId());

    }

    /**
     * 保证缓存和数据的强一致性，修改DB数据后需要删除缓存。
     */
    private void syncDeleteCache(String cacheKeyId) {
        String cacheKeyQueueId = IdGenerator.getId();
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {

            @Override
            public void beforeCommit(boolean flag) {
                // 插入cache_key_queue记录
                CacheKeyQueueEntity cacheKeyQueueEntity = new CacheKeyQueueEntity();
                cacheKeyQueueEntity.setId(cacheKeyQueueId);
                cacheKeyQueueEntity.setCacheKey(cacheKeyId);
                cacheKeyQueueEntity.setCreateTime(LocalDateTime.now());
                cacheKeyQueueMapper.insert(cacheKeyQueueEntity);
                log.info("事务提交前,插入cache_key_queue记录成功，cacheKeyQueueId={}", cacheKeyQueueId);
            }

            @Override
            public void afterCommit() {
                // 同步删除缓存，若删除缓存成功则同步删除cache_key_queue表记录
                globalCacheManager.del(cacheKeyId);
                cacheKeyQueueMapper.logicDeleteById(cacheKeyQueueId);
                log.info("事务提交后,删除缓存成功");
                log.info("事务提交后,删除cache_key_queue记录成功，cacheKeyQueueId={}", cacheKeyQueueId);
            }

            @Override
            public void afterCompletion(int status) {
                // 锁的释放处理
                System.out.println("事务完成(提交或回滚)后处理 " + status);
            }
        });
    }
}
