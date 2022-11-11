package com.jf.mybatis.controller;

import com.jf.common.aspect.log.MethodLogger;
import com.jf.model.result.BaseResult;
import com.jf.mybatis.domain.entity.AccountEntity;
import com.jf.mybatis.domain.param.account.AccountCreateParam;
import com.jf.mybatis.domain.param.account.AccountUpdateParam;
import com.jf.mybatis.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 江峰
 * @create 2020-03-22 11:57
 */
@RestController
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/account/{id}")
    @MethodLogger(apiId = "61dbe11b343ac83c788ff2e3")
    public BaseResult<AccountEntity> getAccountById(@PathVariable String id) {
        AccountEntity accountEntity = accountService.getAccountById(id);
        return BaseResult.success(accountEntity);
    }

    @PostMapping("/account/create")
    @MethodLogger(apiId = "61dbe11b343ac83c788ff2e3")
    public BaseResult<Integer> createAccount(@RequestBody AccountCreateParam param) {
        Integer id = accountService.createAccount(param);
        return BaseResult.success(id);
    }

    @PutMapping("/account/update")
    @MethodLogger(apiId = "61dbe11b343ac83c788ff222")
    public BaseResult<Boolean> updateAccount(@RequestBody AccountUpdateParam param) {
        accountService.updateAccount(param);
        return BaseResult.success(Boolean.TRUE);
    }

    @RequestMapping("/account/transAccount")
    @MethodLogger(apiId = "61dbe11b343ac83c788ff233")
    public List<AccountEntity> transAccount() {
        AccountEntity a1 = accountService.getAccountById("1");
        AccountEntity a2 = accountService.getAccountById("2");
        accountService.transAccount(a1, a2, 1);
        ArrayList<AccountEntity> accountEntityList = new ArrayList<>();
        a1 = accountService.getAccountById("1");
        a2 = accountService.getAccountById("2");
        accountEntityList.add(a1);
        accountEntityList.add(a2);
        return accountEntityList;
    }


}
