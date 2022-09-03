package com.jf.template.controller;

import com.jf.common.aspect.log.MethodLogger;
import com.jf.common.redis.annotation.ReSubmitLock;
import com.jf.model.result.BaseResult;
import com.jf.model.result.PageQueryRequest;
import com.jf.model.result.PageQueryResponse;
import com.jf.template.domain.dto.OrderDTO;
import com.jf.template.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "订单controller", tags = {"订单相关操作接口"})
@RequestMapping("/order")
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "根据订单id查询订单")
    @GetMapping("/{id}")
    @MethodLogger(apiId = "6221ec540a849a4ef44d38fc")
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
    @MethodLogger(apiId = "6221ec540a849a4ef44d38fd")
    public PageQueryResponse<List<OrderDTO>> orderList(
            @RequestBody @Validated PageQueryRequest<OrderDTO> request) {

        System.out.println(request);

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
