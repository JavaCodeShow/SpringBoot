package com.jf.css.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.jf.common.aspect.log.MethodLogger;
import com.jf.common.utils.result.BaseResult;
import com.jf.common.utils.result.PageQueryRequest;
import com.jf.common.utils.result.PageQueryResponse;
import com.jf.css.domain.dto.OrderDTO;
import com.jf.css.service.RedisService;
import com.jf.css.utils.lock.CacheLock;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(value = "订单controller", tags = { "订单相关操作接口" })
@RequestMapping("/order")
@RestController
@Slf4j
public class OrderController {

	@Autowired
	private RedisService redisService;

	@Autowired
	@Qualifier("baseAsyncExecutor")
	private Executor baseAsyncExecutor;

	@ApiOperation(value = "模拟秒杀")
	@RequestMapping("/secskill")
	public BaseResult secskill() {

		AtomicInteger productNum = new AtomicInteger(2);

		String lockValue = UUID.randomUUID().toString();
		int threadCount = 1000;
		AtomicInteger execThreadNum = new AtomicInteger(1);

		for (int i = 0; i < threadCount; i++) {
			baseAsyncExecutor.execute(() -> {
				log.info("第[{}]个线程", execThreadNum.getAndIncrement());
				try {
					boolean success = redisService.tryLock("productId",
							lockValue, 10);
					if (success && productNum.get() > 0) {
						productNum.decrementAndGet();
					}
					log.info("线程名字 = [{}], success = [{}], 剩余数量 = [{}]",
							Thread.currentThread().getName(), success,
							productNum);
				} finally {
					redisService.unLock("productId", lockValue);
				}
				if (execThreadNum.get() == 1000) {
					System.out.println("exit");
				}
			});
		}

		return BaseResult.success();
	}

	@ApiOperation(value = "根据订单id查询订单")
	@GetMapping("/{id}")
	@MethodLogger
	@CacheLock
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
}
