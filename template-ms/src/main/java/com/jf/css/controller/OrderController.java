package com.jf.css.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.jf.common.redis.lock.ReSubmitLock;
import com.jf.common.utils.aspect.log.MethodLogger;
import com.jf.common.utils.result.BaseResult;
import com.jf.common.utils.result.PageQueryRequest;
import com.jf.common.utils.result.PageQueryResponse;
import com.jf.css.domain.dto.OrderDTO;
import com.jf.css.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(value = "订单controller", tags = { "订单相关操作接口" })
@RequestMapping("/order")
@RestController
@Slf4j
public class OrderController {

	@Autowired
	private OrderService orderService;

	@ApiOperation(value = "根据订单id查询订单")
	@GetMapping("/{id}")
	@MethodLogger
	@ReSubmitLock
	public BaseResult<OrderDTO> getOrderById(@PathVariable Integer id) {

		OrderDTO order = new OrderDTO();
		if (id == 1) {
			order = OrderDTO.builder().id(1).orderId(111).name("秀儿，是你吗")
					.build();
		}

		return BaseResult.success(order);
	}

	@ApiOperation(value = "分页查询订单")
	@PostMapping("/list")
	@MethodLogger
	public PageQueryResponse<List<OrderDTO>> orderList(
			@RequestBody @Validated PageQueryRequest<OrderDTO> request) {

		OrderDTO order = OrderDTO.builder().id(1).orderId(111).name("秀儿，是你吗")
				.build();
		List<OrderDTO> orderList = new ArrayList<>();
		orderList.add(order);

		return PageQueryResponse.success(orderList, 10);
	}

	@GetMapping("/event")
	public BaseResult orderEvent() {
		orderService.order();
		return BaseResult.success();
	}

}
