package com.jf.mps.account.proxy;

import com.alibaba.fastjson.JSON;
import com.jf.common.aspect.exception.BizException;
import com.jf.model.request.IdRequest;
import com.jf.model.response.CommonResult;
import com.jf.mps.account.client.AccountClient;
import com.jf.mps.account.info.AccountInfo;
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
            log.error("调用ids服务获取一个id失败, result = [{}]", JSON.toJSONString(result));
            throw new BizException(result.getCode(), result.getMsg());
        }
        return result.getData();
    }


}
