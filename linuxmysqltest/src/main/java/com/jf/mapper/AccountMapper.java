package com.jf.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.jf.pojo.Account;

/**
 * @author 潇潇暮雨
 * @create 2018-10-04 15:27
 */

@Mapper
public interface AccountMapper {
	Account getAccountById(Integer id);

	int updateAccountById(Integer id);
}
