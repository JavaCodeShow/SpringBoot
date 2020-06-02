package com.jf.prometheus.controller;

import com.jf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    public String hello() {
        orderService.order();
        return "下单成功";
    }
}
