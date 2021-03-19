package com.jf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.mapper.AccountMapper;
import com.jf.pojo.Account;

/**
 * @author 潇潇暮雨
 * @create 2018-10-04 15:49
 */
@Controller
public class AccountController {

	@Autowired
	private AccountMapper accountMapper;

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "Hello 林加铭";
	}

	@RequestMapping("/account/{id}")
	@ResponseBody
	public Account getAccountById(@PathVariable Integer id) {
		Account account = accountMapper.getAccountById(id);
		return account;
	}

	@PutMapping("/account/{id}")
	@ResponseBody
	public Integer updateAccountById(@PathVariable Integer id) {
		// 并发执行这个sql。将money减一
		// ExecutorService es = Executors.newFixedThreadPool(100);
		// for (int i = 0; i < 100; i++) {
		// es.execute(new Runnable() {
		// @Override
		// public void run() {
		// accountMapper.updateAccountById(id);
		// }
		// });
		// }
		// return 0;
		return accountMapper.updateAccountById(id);
	}
}
