package com.jf.mps.user.info;

import com.jf.model.response.BaseInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author 江峰
 * @create 2020-03-22 11:46
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class UserInfo extends BaseInfo {
    private String id;
    private String name;
    private String phone;
    private BigDecimal money;
    private String password;

}
