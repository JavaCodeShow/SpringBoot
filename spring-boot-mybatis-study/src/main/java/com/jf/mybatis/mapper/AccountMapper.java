package com.jf.mybatis.mapper;

import com.jf.mybatis.pojo.Account;
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
    Integer updateAccountById(Account account);

    /**
     * 根据id查询账户
     *
     */
    Account getAccountById(Integer id);

    List<Account> getAccountByMoneyAndName(Account account);

    List<Account> getAccountByMoneys(int[] moneys);
}
