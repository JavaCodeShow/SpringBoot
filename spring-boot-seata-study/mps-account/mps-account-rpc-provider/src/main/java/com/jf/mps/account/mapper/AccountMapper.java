package com.jf.mps.account.mapper;

import com.jf.mps.account.domain.entity.AccountEntity;
import com.jf.mps.account.param.AccountCreateOrUpdateParam;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 江峰
 * @create 2020-03-22 11:41
 */
@Mapper
public interface AccountMapper {

    AccountEntity findById(String id);

    void insert(AccountCreateOrUpdateParam param);
}
