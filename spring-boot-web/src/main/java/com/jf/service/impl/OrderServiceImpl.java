package com.jf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.jf.event.OrderSuccessEvent;
import com.jf.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public void order() {
		// 下单成功
		System.out.println("下单成功...");
		// 发布通知
		applicationContext.publishEvent(new OrderSuccessEvent(this));
		System.out.println("main线程结束...");
	}
}
