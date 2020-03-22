package com.jf.mybatis.controller;

import com.jf.mybatis.pojo.Account;
import com.jf.mybatis.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 江峰
 * @create 2020-03-22   11:57
 */
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @RequestMapping("/account/transAccount")
    @ResponseBody
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
    @ResponseBody
    public Account transAccount(@PathVariable Integer id) {
        Account accountById = accountService.getAccountById(id);
        return accountById;
    }


}
