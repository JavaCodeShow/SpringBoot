package com.jf.nacos.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jf.common.utils.aspect.log.MethodLogger;
import com.jf.common.utils.result.BaseResult;
import com.jf.nacos.domain.dto.OrderDTO;

/**
 * @author 潇潇暮雨
 * @create 2018-09-29 22:12
 */

@RestController
public class OrderController {

	@GetMapping("/order/{orderId}")
	@MethodLogger
	public BaseResult<OrderDTO> getOrderById(@PathVariable Integer orderId) {

		OrderDTO orderDTO = new OrderDTO();
		if (orderId == 1) {
			// orderDTO.setName("秀儿，是你吗？");
			orderDTO.setReason("秀儿，是你吗？");
		}
		if (orderId == 2) {
			int i = 1 / 0;
		}
		if (orderId == 3) {
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return BaseResult.success(orderDTO);
	}

}
