package com.jf.mps.account.service.impl;


import com.jf.mps.account.domain.entity.AccountEntity;
import com.jf.mps.account.info.AccountInfo;

/**
 * @author 江峰
 */
public interface AccountService {
    AccountInfo findById(String id);
}
