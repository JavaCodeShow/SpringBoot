package com.jf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jf.domain.entity.Order;
import com.jf.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "订单controller", tags = { "订单相关操作接口" })
@RequestMapping("/order")
@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;

	public String hello() {
		orderService.order();
		return "下单成功";
	}

	@ApiOperation(value = "根据订单id查询订单")
	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable Integer id) {
		Order order = new Order();
		if (id == 1) {
			order = Order.builder().id(1).orderId(111).name("秀儿，是你吗").build();
		}

		return order;
	}
}
