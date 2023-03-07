package com.jf.mps.user.domain.entity;

import com.jf.model.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author 江峰
 * @create 2020-03-22 11:46
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class UserEntity extends BaseEntity {
    private String id;
    private String name;
    private String phone;
    private String email;

}
