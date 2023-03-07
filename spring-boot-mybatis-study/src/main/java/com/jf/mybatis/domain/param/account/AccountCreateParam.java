package com.jf.mybatis.domain.param.account;

import com.jf.model.entity.BaseEntity;
import lombok.Data;

@Data
public class AccountCreateParam extends BaseEntity {
    private Integer id;
    private Integer money;
    private String name;

}
