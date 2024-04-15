package com.jf.mybatis.domain.param.account;

import com.jf.model.request.BaseParam;
import com.jf.model.request.ParamChecker;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AccountUpdateParam extends BaseParam {

    private String id;
    private Integer money;
    private String userId;

    @Override
    public void checkParam() {
        ParamChecker.notBlank(id, "id 不能为空");
        ParamChecker.notNull(money, "money 不能为空");
        ParamChecker.notBlank(userId, "userId 不能为空");
    }
}
