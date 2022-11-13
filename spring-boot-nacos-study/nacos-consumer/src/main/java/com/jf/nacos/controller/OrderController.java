package com.jf.nacos.controller;

import com.jf.common.aspect.log.MethodLogger;
import com.jf.model.result.CommonResult;
import com.jf.nacos.domain.dto.OrderDTO;
import com.jf.nacos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author 潇潇暮雨
 * @create 2018-09-29 22:12
 */

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/{orderId}")
    @MethodLogger(apiId = "62a30deb3785be2a4c58cde1")
    public CommonResult<OrderDTO> getOrderById(@PathVariable Integer orderId) {

        OrderDTO orderDTO = orderService.getOrderById(orderId);
        if (Objects.isNull(orderDTO)) {
            return CommonResult.fail();
        }
        return CommonResult.success(orderDTO);
    }
}
