package com.jf.mps.account.proxy;

import lombok.extern.slf4j.Slf4j;
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

    // @Autowired
    // private IdsClient idsClient;

    // /**
    //  * 获取一个id
    //  */
    // public Long getId() {
    //     CommonResult<Long> result = idsClient.getId();
    //     if (!result.getSuccess()) {
    //         log.error("调用ids服务获取一个id失败, result = [{}]", JSON.toJSON(result));
    //         throw new BizException(result.getCode(), result.getMsg());
    //     }
    //     return result.getData();
    // }


}
