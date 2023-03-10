package cn.hyy.account.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 账户
 * @author: zyf
 * @date: 2022/01/24
 * @version: V1.0
 */
@Data
@Builder
public class SeataAccount {
    private Long id;

    /**
     * 余额
     */
    private BigDecimal balance;

    private Date lastUpdateTime;
}
