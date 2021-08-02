package com.jf.nacos.service;

import com.jf.nacos.domain.dto.OrderDTO;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-03-24 21:30
 * @since: 2.22.1
 */
public interface OrderService {

    OrderDTO getOrderById(Integer orderId);

}
