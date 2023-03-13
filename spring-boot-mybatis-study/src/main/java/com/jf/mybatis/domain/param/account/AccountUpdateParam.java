package com.jf.mybatis.domain.param.account;

import com.jf.model.request.BaseParam;
import lombok.Data;

@Data
public class AccountUpdateParam extends BaseParam {
    private String id;
    private Integer money;
    private String userId;

    @Override
    public void checkParam() {

    }
}
