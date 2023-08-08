package com.jf.mybatis.controller;

import com.jf.common.aspect.log.MethodLogger;
import com.jf.model.request.GenericRequest;
import com.jf.model.response.CommonResult;
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
    public CommonResult<AccountEntity> findById(@PathVariable String id) {
        AccountEntity accountEntity = accountService.findById(id);
        return CommonResult.success(accountEntity);
    }

    @PostMapping("/account/create")
    @MethodLogger(apiId = "61dbe11b343ac83c788ff2e3")
    public CommonResult<Integer> createAccount(@RequestBody GenericRequest<AccountCreateParam> request) {
        Integer id = accountService.createAccount(request.getParam());
        return CommonResult.success(id);
    }

    @PutMapping("/account/update")
    @MethodLogger(apiId = "61dbe11b343ac83c788ff222")
    public CommonResult<Boolean> updateAccount(@RequestBody GenericRequest<AccountUpdateParam> request) {
        accountService.updateAccount(request.getParam());
        return CommonResult.success(Boolean.TRUE);
    }

    @RequestMapping("/account/transAccount")
    @MethodLogger(apiId = "61dbe11b343ac83c788ff233")
    public List<AccountEntity> transAccount() {
        AccountEntity a1 = accountService.findById("1");
        AccountEntity a2 = accountService.findById("2");
        accountService.transAccount(a1, a2, 1);
        ArrayList<AccountEntity> accountEntityList = new ArrayList<>();
        a1 = accountService.findById("1");
        a2 = accountService.findById("2");
        accountEntityList.add(a1);
        accountEntityList.add(a2);
        return accountEntityList;
    }


}
