package com.jf.mybatis.service;

import com.jf.mybatis.domain.entity.AccountEntity;
import com.jf.mybatis.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        accountEntity1.setMoney(accountEntity1.getMoney() - money);
        accountEntity2.setMoney(accountEntity2.getMoney() + money);
        Integer i1 = accountMapper.updateAccountById(accountEntity1);
        Integer i2 = accountMapper.updateAccountById(accountEntity2);

        // 手动异常
        // throw new IllegalArgumentException("出异常了，数据将回滚" + accountMapper.getAccountById(1));

    }

    public AccountEntity getAccountById(Integer id) {
        return accountMapper.getAccountById(id);
    }
}
