package com.jf.mps.account.info;

import com.jf.model.response.BaseInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 江峰
 * @create 2020-03-22 11:46
 */

@Data
public class AccountInfo {
    private Integer id;
    private Integer money;
    private String name;

}
