package com.jf.mps.account.param;

import com.jf.model.request.BaseParam;
import com.jf.model.request.ParamChecker;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;


@EqualsAndHashCode(callSuper = true)
@Data
public class AccountCreateOrUpdateParam extends BaseParam {

    private String id;

    private String userId;

    private BigDecimal money;


    @Override
    public void checkParam() {
        ParamChecker.notBlank(userId, "userId 不能为空");
        ParamChecker.notNull(money, "money 不能为空");
    }
}
