package com.jf.mps.account.service.impl;


import com.jf.mps.account.domain.entity.AccountEntity;

/**
 * @author 江峰
 */
public interface AccountService {
    AccountEntity findById(String id);
}
