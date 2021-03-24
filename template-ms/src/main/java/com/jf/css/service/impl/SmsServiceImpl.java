package com.jf.css.service.impl;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.jf.css.listener.event.OrderSuccessEvent;
import com.jf.css.service.SmsService;

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
