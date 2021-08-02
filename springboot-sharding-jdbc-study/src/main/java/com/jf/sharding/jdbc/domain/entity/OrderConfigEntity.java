package com.jf.sharding.jdbc.domain.entity;

import lombok.Data;

/**
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2021-05-27 23:51:50
 * @since
 */
@Data
public class OrderConfigEntity {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 支付超时时间
     * <p>
     * 单位：分钟
     */
    private Integer payTimeout;
}
