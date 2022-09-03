package com.jf.nacos.controller;

import com.jf.common.aspect.log.MethodLogger;
import com.jf.model.result.BaseResult;
import com.jf.nacos.domain.dto.OrderDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author 潇潇暮雨
 * @create 2018-09-29 22:12
 */

@RestController
public class OrderController {

    @GetMapping("/order/{orderId}")
    @MethodLogger(apiId = "62a30deb3785be2a4c58cdea")
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
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return BaseResult.success(orderDTO);
    }

}
