package com.jf.mapper;

import com.jf.pojo.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 潇潇暮雨
 * @create 2018-10-04   15:27
 */

@Mapper
public interface AccountMapper {
    Account getAccountById(Integer id);

    int updateAccountById(Integer id);

    Integer insertAccount(Account account);

    List<Account> getAccountByName(String name);
}
