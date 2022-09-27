package com.jf.mybatis.controller;

import com.jf.common.aspect.log.MethodLogger;
import com.jf.model.result.BaseResult;
import com.jf.mybatis.domain.entity.AccountEntity;
import com.jf.mybatis.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 江峰
 * @create 2020-03-22 11:57
 */
@RestController
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/hello")
    @MethodLogger(apiId = "61dbe11b343ac83c788ff211")
    public String hello() {
        log.info("info 日志");
        log.debug("debug日志");
        log.error("debug日志");
        log.trace("trace日志");
        return "hello";
    }

    @RequestMapping("/changeI")
    @MethodLogger(apiId = "61dbe11b343ac83c788ff222")
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
    @MethodLogger(apiId = "61dbe11b343ac83c788ff233")
    public List<AccountEntity> transAccount() {
        AccountEntity a1 = accountService.getAccountById(1);
        AccountEntity a2 = accountService.getAccountById(2);
        accountService.transAccount(a1, a2, 1);
        ArrayList<AccountEntity> accountEntityList = new ArrayList<>();
        a1 = accountService.getAccountById(1);
        a2 = accountService.getAccountById(2);
        accountEntityList.add(a1);
        accountEntityList.add(a2);
        return accountEntityList;
    }

    @RequestMapping("/account/{id}")
    @MethodLogger(apiId = "61dbe11b343ac83c788ff2e3")
    public BaseResult<AccountEntity> getAccountById(@PathVariable Integer id) {
        AccountEntity accountEntity = accountService.getAccountById(id);
        return BaseResult.success(accountEntity);
    }

    @PostMapping("/account/create")
    @MethodLogger(apiId = "61dbe11b343ac83c788ff2e3")
    public BaseResult<AccountEntity> createAccount(@RequestBody AccountEntity accountEntity) {

        return BaseResult.success(accountEntity);
    }

}
