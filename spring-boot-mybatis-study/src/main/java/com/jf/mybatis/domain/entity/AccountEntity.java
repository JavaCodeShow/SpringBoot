package com.jf.mybatis.domain.entity;

import lombok.Data;

/**
 * @author 江峰
 * @create 2020-03-22 11:46
 */

@Data
public class AccountEntity {
    private Integer id;
    private Integer money;
    private String name;

    private boolean isDeleted;

}
