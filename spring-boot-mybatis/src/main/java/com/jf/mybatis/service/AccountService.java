package com.jf.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jf.mybatis.mapper.AccountMapper;
import com.jf.mybatis.pojo.Account;

/**
 * @author 江峰
 * @create 2020-03-22 11:40
 */
@Service
public class AccountService {
	private int i = 0;
	@Autowired
	private AccountMapper accountMapper;

	public int getI() {
		return this.i;
	}

	public void changeI() {
		System.out.println(Thread.currentThread().getName() + " i = " + getI());
		Thread.yield();
		Thread.yield();
		System.out.println(Thread.currentThread().getName() + ": " + ++i);
		Thread.yield();
		Thread.yield();
		System.out.println(Thread.currentThread().getName() + " i = " + getI());
	}

	/**
	 * 账户一向账户二转money。
	 *
	 * @param account1
	 * @param account2
	 * @param money
	 */
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void transAccount(Account account1, Account account2,
			Integer money) {
		account1.setMoney(account1.getMoney() - money);
		account2.setMoney(account2.getMoney() + money);
		Integer i1 = accountMapper.updateAccountById(account1);

		// 手动异常
		// int num = 0;
		// if (num == 0) {
		// throw new IllegalArgumentException(
		// "出异常了，数据将回滚" + accountMapper.getAccountById(1));
		// }

		Integer i2 = accountMapper.updateAccountById(account2);
	}

	public Account getAccountById(Integer id) {
		return accountMapper.getAccountById(id);
	}
}
