package com.jf.mps.account.service.impl;


import com.jf.mps.account.info.AccountInfo;
import com.jf.mps.account.param.AccountCreateOrUpdateParam;

/**
 * @author 江峰
 */
public interface AccountService {
    AccountInfo findById(String id);

    String createOrUpdate(AccountCreateOrUpdateParam param);
}
