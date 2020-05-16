package com.jf.service.impl;

import com.jf.event.OrderSuccessEvent;
import com.jf.service.CarService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


@Service
public class CarServiceImpl implements CarService {

    @EventListener(OrderSuccessEvent.class)
    public void dispatch() {
        System.out.println("发车咯...");
    }
}
