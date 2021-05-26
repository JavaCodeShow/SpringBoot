package com.jf.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jf.mybatis.pojo.Account;

/**
 * @author 江峰
 * @create 2020-03-22 11:41
 */
@Mapper
public interface AccountMapper {

	/**
	 * 给id这个人加钱
	 *
	 * @param account
	 */
	Integer updateAccountById(Account account);

	/**
	 * 根据id查询账户
	 *
	 * @param id
	 */
	Account getAccountById(Integer id);

	List<Account> getAccountByMoneyAndName(Account account);

	List<Account> getAccountByMoneys(int[] moneys);
}
