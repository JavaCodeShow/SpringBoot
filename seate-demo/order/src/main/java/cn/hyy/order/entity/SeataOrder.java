package cn.hyy.order.entity;

import cn.hyy.order.enums.OrderStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description: 订单
 * @author: zyf
 * @date: 2022/01/24
 * @version: V1.0
 */
@Builder
@Data
public class SeataOrder {

    private Integer id;

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 商品ID
     */
    private Long productId;
    /**
     * 订单状态
     */
    private OrderStatus status;
    /**
     * 数量
     */
    private Integer count;
    /**
     * 总金额
     */
    private BigDecimal totalPrice;
}
