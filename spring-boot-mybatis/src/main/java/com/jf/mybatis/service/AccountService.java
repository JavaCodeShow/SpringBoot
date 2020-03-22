package com.jf.mybatis.service;

import com.jf.mybatis.mapper.AccountMapper;
import com.jf.mybatis.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 江峰
 * @create 2020-03-22   11:40
 */
@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    /**
     * 账户一向账户二转money。
     *
     * @param account1
     * @param account2
     * @param money
     */
    @Transactional
    public String transAccount(Account account1, Account account2, Integer money) {
        account1.setMoney(account1.getMoney() - money);
        account2.setMoney(account2.getMoney() + money);
        String res = "";
        try {
            Integer i1 = accountMapper.updateAccountById(account1);
            int i = 1 / 0;
            Integer i2 = accountMapper.updateAccountById(account2);
        } catch (Exception e) {
            res = "trans fail";
        }
        res = " trans ok";
        return res;
    }


    public Account getAccountById(Integer id) {
        return accountMapper.getAccountById(id);
    }
}
