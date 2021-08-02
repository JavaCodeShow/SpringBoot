package com.jf.template.service.impl;

import com.jf.template.mq.event.OrderSuccessEvent;
import com.jf.template.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void order() {

        // 下单成功
        log.info("下单成功...");

        // 发布通知（各个listener是异步执行的）
        applicationContext.publishEvent(new OrderSuccessEvent(this));

        log.info("发布下单成功消息结束...");
    }
}
