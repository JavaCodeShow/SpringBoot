package com.jf.css.listener.order.event;

import org.springframework.context.ApplicationEvent;

/**
 * 用户下单成功事件
 */
public class OrderSuccessEvent extends ApplicationEvent {

	public OrderSuccessEvent(Object source) {
		super(source);
	}
}
