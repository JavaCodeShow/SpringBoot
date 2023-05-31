package com.jf.mybatis.mapper;

import com.jf.mybatis.domain.entity.AccountEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 江峰
 * @create 2020-03-22 11:41
 */
@Mapper
public interface AccountMapper {

    AccountEntity findById(String id);

    int insert(AccountEntity accountEntity);

    int delete(String id);

    Integer updateMoneyById(AccountEntity accountEntity);

    int updateByPrimaryKey(AccountEntity accountEntity);
}
