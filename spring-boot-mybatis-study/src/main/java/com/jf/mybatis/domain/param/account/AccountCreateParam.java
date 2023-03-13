package com.jf.mybatis.domain.param.account;

import com.jf.model.request.BaseParam;
import com.jf.model.request.ParamChecker;
import lombok.Data;

@Data
public class AccountCreateParam extends BaseParam {
    private Integer id;
    private Integer money;
    private String userId;

    @Override
    public void checkParam() {
        ParamChecker.notBlank(userId, "userId不能为空");
    }
}
