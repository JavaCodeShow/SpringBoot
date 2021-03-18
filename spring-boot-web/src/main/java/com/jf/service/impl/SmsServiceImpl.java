package com.jf.service.impl;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.jf.event.OrderSuccessEvent;
import com.jf.service.SmsService;

@Service
public class SmsServiceImpl
		implements SmsService, ApplicationListener<OrderSuccessEvent> {

	@Override
	public void onApplicationEvent(OrderSuccessEvent orderSuccessEvent) {
		this.sendSms();
	}

	/**
	 * 发送短信
	 */
	public void sendSms() {
		System.out.println("发送短信...");
	}

}
