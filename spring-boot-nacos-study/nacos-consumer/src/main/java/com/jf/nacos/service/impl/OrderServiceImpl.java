package com.jf.nacos.service.impl;

import com.jf.model.result.BaseResult;
import com.jf.nacos.client.FcsClient;
import com.jf.nacos.domain.dto.OrderDTO;
import com.jf.nacos.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-03-24 21:30
 * @since: 2.22.1
 */

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private FcsClient fcsClient;

    @Override
    public OrderDTO getOrderById(Integer orderId) {

        BaseResult<OrderDTO> result = fcsClient.getOrderById(orderId);

        if (!result.getSuccess()) {
            log.error(result.getMsg() + " orderId = [{}]", orderId);
            return null;
        }

        return result.getData();
    }
}
