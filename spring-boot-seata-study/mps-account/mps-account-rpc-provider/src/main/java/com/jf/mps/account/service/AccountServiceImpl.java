package com.jf.mps.account.service;

import com.jf.mps.account.domain.entity.AccountEntity;
import com.jf.mps.account.mapper.AccountMapper;
import com.jf.mps.account.service.impl.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 江峰
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public AccountEntity findById(String id) {
        AccountEntity accountEntity = accountMapper.findById(id);
        return accountEntity;
    }


}
