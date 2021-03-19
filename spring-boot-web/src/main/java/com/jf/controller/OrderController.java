package com.jf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jf.domain.dto.OrderDTO;
import com.jf.utils.result.BaseResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "订单controller", tags = { "订单相关操作接口" })
@RequestMapping("/order")
@RestController
public class OrderController {

	@ApiOperation(value = "根据订单id查询订单")
	@GetMapping("/{id}")
	public BaseResult<OrderDTO> getOrderById(@PathVariable Integer id) {
		OrderDTO order = new OrderDTO();
		if (id == 1) {
			order = OrderDTO.builder().id(1).orderId(111).name("秀儿，是你吗")
					.build();
		}
		BaseResult baseResult = new BaseResult().ofSuccess(order);

		return new BaseResult().ofSuccess(order);
	}
}
