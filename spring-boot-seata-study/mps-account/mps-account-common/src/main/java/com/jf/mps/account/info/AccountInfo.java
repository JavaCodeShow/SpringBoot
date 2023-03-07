package com.jf.mps.account.info;

import com.jf.model.response.BaseInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 江峰
 * @create 2020-03-22 11:46
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class AccountInfo extends BaseInfo{
    private Integer id;
    private Integer money;
    private String name;

}
