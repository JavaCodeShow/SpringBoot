package com.jf.sharding.jdbc.domain.entity;

import lombok.Data;

/**
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2021-05-27 23:44:31
 * @since
 */
@Data
public class OrderEntity {

    /**
     * 订单编号
     */
    private Long id;
    /**
     * 用户编号
     */
    private Integer userId;
}
