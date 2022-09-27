package com.jf.mybatis.mapper;

import com.jf.mybatis.domain.entity.AccountEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 江峰
 * @create 2020-03-22 11:41
 */
@Mapper
public interface AccountMapper {

    AccountEntity findById(Integer id);

    int insert(AccountEntity accountEntity);

    int delete(int id);

    Integer updateMoneyById(AccountEntity accountEntity);

    List<AccountEntity> getAccountByMoneyAndName(AccountEntity accountEntity);

    List<AccountEntity> getAccountByMoneys(int[] moneys);

}
