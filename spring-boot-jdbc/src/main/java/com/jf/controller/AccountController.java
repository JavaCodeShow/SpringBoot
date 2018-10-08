package com.jf.controller;

import com.jf.mapper.AccountMapper;
import com.jf.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Account getAccountById(@PathVariable Integer id){
        Account account = accountMapper.getAccountById(id);
        return account;
    }


}
