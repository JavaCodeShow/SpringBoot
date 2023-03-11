package com.jf.mps.account.controller;

import com.jf.common.aspect.log.MethodLogger;
import com.jf.model.request.GenericRequest;
import com.jf.model.request.IdRequest;
import com.jf.model.response.CommonResult;
import com.jf.mps.account.api.AccountApi;
import com.jf.mps.account.info.AccountInfo;
import com.jf.mps.account.param.AccountCreateOrUpdateParam;
import com.jf.mps.account.service.impl.AccountService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-03-25 4:17
 * @since: 2.22.1
 */
@Api(value = "分布式id服务controller", tags = {"分布式id"})
@RestController
@Slf4j
public class AccountController implements AccountApi {

    @Autowired
    private AccountService accountService;

    @MethodLogger(apiId = "6221deeb0a849a5acc9cb183")
    public CommonResult<AccountInfo> findById(IdRequest request) {
        AccountInfo info = accountService.findById(request.getId());
        return CommonResult.success(info);
    }

    @MethodLogger(apiId = "6221deeb0a849a5acc9cb111")
    @Override
    public CommonResult<String> createOrUpdate(GenericRequest<AccountCreateOrUpdateParam> request) {
        String id = accountService.createOrUpdate(request.getParam());
        return CommonResult.success(id);
    }

}
