package com.jf.mps.account.domain.entity;

import com.jf.model.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author 江峰
 * @create 2020-03-22 11:46
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class AccountEntity extends BaseEntity {

    private String id;

    private String userId;

    private BigDecimal money;


}
