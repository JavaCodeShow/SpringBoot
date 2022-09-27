package com.jf.mybatis.service;

import com.jf.mybatis.domain.entity.AccountEntity;
import com.jf.mybatis.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author 江峰
 */
@Service
public class AccountService {
    private int i = 0;

    @Autowired
    private AccountMapper accountMapper;

    public int getI() {
        return this.i;
    }

    public void changeI() {
        System.out.println(Thread.currentThread().getName() + " i = " + getI());
        Thread.yield();
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + ": " + ++i);
        Thread.yield();
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " i = " + getI());
    }

    /**
     * 账户一向账户二转money。
     */
    @Transactional(rollbackFor = Exception.class)
    public void transAccount(AccountEntity accountEntity1,
                             AccountEntity accountEntity2,
                             Integer money) {
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {

            @Override
            public void beforeCommit(boolean flag) {
                AccountEntity accountEntity = new AccountEntity();
                accountMapper.insert(accountEntity);
                System.out.println("事务提交前 " + false);
            }

            @Override
            public void afterCommit() {
                System.out.println("事务提交后");
            }

            @Override
            public void afterCompletion(int status) {
                System.out.println("事务完成(提交或回滚)后处理 " + status);
            }
        });
        accountEntity1.setMoney(accountEntity1.getMoney() - money);
        accountEntity2.setMoney(accountEntity2.getMoney() + money);
        accountMapper.updateAccountById(accountEntity1);
        accountMapper.updateAccountById(accountEntity2);

        // 手动异常
        // throw new IllegalArgumentException("出异常了，数据将回滚" + accountMapper.getAccountById(1));

    }

    public AccountEntity getAccountById(Integer id) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(3);
        accountEntity.setMoney(10);
        accountEntity.setName("王五");
        accountMapper.insert(accountEntity);
        return accountMapper.getAccountById(id);
    }
}
