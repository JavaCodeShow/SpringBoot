package com.jf.mps.account.proxy;

import com.alibaba.fastjson.JSON;
import com.jf.model.exception.BizException;
import com.jf.model.request.GenericRequest;
import com.jf.model.request.IdRequest;
import com.jf.model.response.CommonResult;
import com.jf.mps.account.client.AccountClient;
import com.jf.mps.account.info.AccountInfo;
import com.jf.mps.account.param.AccountCreateOrUpdateParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Ids对外暴露的实现类
 *
 * @author 江峰
 * @since 2021/9/12
 */
@Service
@Slf4j
public class AccountProxy {

    @Autowired
    private AccountClient accountClient;

    public AccountInfo findById(String id) {
        IdRequest request = new IdRequest();
        request.setId(id);
        CommonResult<AccountInfo> result = accountClient.findById(request);
        if (!result.getSuccess()) {
            log.warn("调用account服务失败,AccountProxy.findById, result = [{}]", JSON.toJSONString(result));
            throw new BizException(result.getCode(), result.getMessage());
        }
        return result.getData();
    }

    public String createOrUpdate(AccountCreateOrUpdateParam param) {
        GenericRequest<AccountCreateOrUpdateParam> request = new GenericRequest<>(param);
        CommonResult<String> result = accountClient.createOrUpdate(request);
        if (!result.getSuccess()) {
            log.warn("调用account服务失败,AccountProxy.createOrUpdate, result = [{}]", JSON.toJSONString(result));
            throw new BizException(result.getCode(), result.getMessage());
        }
        return result.getData();
    }


}
