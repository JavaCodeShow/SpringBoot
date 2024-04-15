package com.jf.mybatis.service;

import com.jf.common.redis.manager.cache.DistributedCacheManager;
import com.jf.common.utils.bean.ApplicationContextUtils;
import com.jf.model.request.ParamChecker;
import com.jf.mybatis.domain.entity.AccountEntity;
import com.jf.mybatis.domain.param.account.AccountCreateParam;
import com.jf.mybatis.domain.param.account.AccountUpdateParam;
import com.jf.mybatis.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 江峰
 */
@Service
@Slf4j
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private CacheKeyQueueService cacheKeyQueueService;

    @Autowired
    private DistributedCacheManager distributedCacheManager;

    public AccountEntity findById(String id) {
        // String value = distributedCacheManager.get(id);
        // if (StringUtils.isNotBlank(value)) {
        //     return JSONObject.parseObject(value, AccountEntity.class);
        // }
        AccountEntity accountEntity = accountMapper.findById(id);
        // distributedCacheManager.set(id, JSONObject.toJSONString(accountEntity));
        return accountEntity;
    }

    /**
     * 账户一向账户二转money。
     */

    public void transAccount(AccountEntity accountEntity1,
                             AccountEntity accountEntity2,
                             Integer money) {
        accountEntity1.setMoney(accountEntity1.getMoney() - money);
        accountEntity2.setMoney(accountEntity2.getMoney() + money);

        ApplicationContextUtils.getBean(AccountService.class).doTransAccount(accountEntity1, accountEntity2);

        // 手动异常
        // throw new IllegalArgumentException("出异常了，数据将回滚" + accountMapper.getAccountById(1));

    }

    @Transactional(rollbackFor = Exception.class)
    public void doTransAccount(AccountEntity accountEntity1, AccountEntity accountEntity2) {
        accountMapper.updateMoneyById(accountEntity1);
        accountMapper.updateMoneyById(accountEntity2);
    }

    public Integer createAccount(AccountCreateParam param) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(param.getId());
        accountEntity.setMoney(param.getMoney());
        accountEntity.setUserId(param.getUserId());
        accountMapper.insert(accountEntity);
        return accountEntity.getId();
    }

    @Transactional
    public void updateAccount(AccountUpdateParam param) {

        AccountEntity accountEntity = accountMapper.findById(param.getId());
        ParamChecker.notNull(accountEntity, "账户不能为空");
        accountEntity.setUserId(param.getUserId());
        accountEntity.setMoney(param.getMoney());
        accountMapper.updateByPrimaryKey(accountEntity);

        cacheKeyQueueService.syncDeleteCache(param.getId());

    }


}
