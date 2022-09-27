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

    /**
     * 给id这个人加钱
     */
    Integer updateAccountById(AccountEntity accountEntity);

    /**
     * 根据id查询账户
     */
    AccountEntity findById(Integer id);

    List<AccountEntity> getAccountByMoneyAndName(AccountEntity accountEntity);

    List<AccountEntity> getAccountByMoneys(int[] moneys);

    int insert(AccountEntity accountEntity);

    int delete(int id);
}
