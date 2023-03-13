package com.jf.mybatis.domain.entity;

import com.jf.model.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

/**
 * @author 江峰
 * @create 2020-03-22 11:46
 */

@Data
@ToString(callSuper = true)
public class AccountEntity extends BaseEntity {
    private Integer id;
    private Integer money;
    private String userId;

}
