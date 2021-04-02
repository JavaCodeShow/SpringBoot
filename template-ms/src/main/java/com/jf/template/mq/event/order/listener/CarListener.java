package com.jf.template.mq.event.order.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.jf.template.mq.event.OrderSuccessEvent;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2021-03-27 18:33:36
 * @since
 */
@Component
@Slf4j
public class CarListener {

	/**
	 * 准备发车
	 */
	@EventListener(OrderSuccessEvent.class)
	public void startCar() {

		log.info("准备发车...");
		log.info("异步执行准备发车的业务逻辑....");

	}
}
