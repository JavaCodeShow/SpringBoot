package com.jf.mps.user.proxy;

import com.alibaba.fastjson.JSON;
import com.jf.model.exception.BizException;
import com.jf.model.request.IdRequest;
import com.jf.model.response.CommonResult;
import com.jf.mps.user.client.UserClient;
import com.jf.mps.user.info.UserInfo;
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
public class UserProxy {

    @Autowired
    private UserClient userClient;

    public UserInfo findById(String id) {
        IdRequest request = new IdRequest();
        request.setId(id);
        CommonResult<UserInfo> result = userClient.findById(request);
        if (!result.getSuccess()) {
            log.warn("调用ids服务获取一个id失败, result = [{}]", JSON.toJSONString(result));
            throw new BizException(result.getCode(), result.getMessage());
        }
        return result.getData();
    }


}
