package com.jf.mybatis.domain.param.account;

import lombok.Data;

@Data
public class AccountUpdateParam {
    private String id;
    private Integer money;
    private String name;
}
