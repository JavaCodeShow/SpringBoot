package com.jf.mybatis.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jf.common.utils.aspect.log.MethodLogger;
import com.jf.common.utils.result.BaseResult;
import com.jf.mybatis.pojo.Account;
import com.jf.mybatis.service.AccountService;

/**
 * @author 江峰
 * @create 2020-03-22 11:57
 */
@RestController
public class AccountController {
	private static final Logger logger = LoggerFactory
			.getLogger(AccountController.class);

	@Autowired
	private AccountService accountService;

	@RequestMapping("/hello")
	@MethodLogger
	public String hello() {
		logger.info("info 日志");
		logger.debug("debug日志");
		logger.error("debug日志");
		logger.trace("trace日志");
		return "hello";
	}

	@RequestMapping("/changeI")
	@MethodLogger
	public String changeI() throws InterruptedException {
		ExecutorService es = Executors.newCachedThreadPool();
		int count = 100;
		CountDownLatch countDownLatch = new CountDownLatch(count);
		for (int i = 0; i < count; i++) {
			es.execute(new Runnable() {
				@Override
				public void run() {
					accountService.changeI();
					countDownLatch.countDown();
				}
			});
		}
		es.shutdown();
		System.out.println("success");
		countDownLatch.await();
		System.out.println("end");
		return accountService.getI() + "";
	}

	@RequestMapping("/account/transAccount")
	@MethodLogger
	public List<Account> transAccount() {
		Account a1 = accountService.getAccountById(1);
		Account a2 = accountService.getAccountById(2);
		accountService.transAccount(a1, a2, 1);
		ArrayList<Account> accountList = new ArrayList<>();
		a1 = accountService.getAccountById(1);
		a2 = accountService.getAccountById(2);
		accountList.add(a1);
		accountList.add(a2);
		return accountList;
	}

	@RequestMapping("/account/{id}")
	@MethodLogger
	public BaseResult<Account> transAccount(@PathVariable Integer id) {
		Account accountById = accountService.getAccountById(id);
		return BaseResult.success(accountById);
	}

}
