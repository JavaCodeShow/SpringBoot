package com.jf.controller;

import com.jf.aspect.log.MethodLogger;
import com.jf.domain.dto.OrderDTO;
import com.jf.utils.result.BaseResult;
import com.jf.utils.result.PageQueryRequest;
import com.jf.utils.result.PageQueryResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "订单controller", tags = {"订单相关操作接口"})
@RequestMapping("/order")
@RestController
@Slf4j
public class OrderController {

    @ApiOperation(value = "根据订单id查询订单")
    @GetMapping("/{id}")
    @MethodLogger
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
    public PageQueryResponse<List<OrderDTO>> orderList(@RequestBody PageQueryRequest<OrderDTO> request) {

        OrderDTO order = OrderDTO.builder().id(1).orderId(111).name("秀儿，是你吗")
                .build();
        List<OrderDTO> orderList = new ArrayList<>();
        orderList.add(order);

        return PageQueryResponse.success(orderList, 10);
    }
}
