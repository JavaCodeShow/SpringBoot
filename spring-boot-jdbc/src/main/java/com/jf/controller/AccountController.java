package com.jf.controller;

import com.jf.mapper.AccountMapper;
import com.jf.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 潇潇暮雨
 * @create 2018-10-04   15:49
 */
@Controller
public class AccountController {

    @Autowired
    private AccountMapper accountMapper;

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
        //     es.execute(new Runnable() {
        //         @Override
        //         public void run() {
        //             accountMapper.updateAccountById(id);
        //         }
        //     });
        // }
        // return 0;
        return accountMapper.updateAccountById(id);
    }
}
