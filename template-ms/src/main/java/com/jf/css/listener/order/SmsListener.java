package com.jf.css.listener.order;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.jf.css.listener.order.event.OrderSuccessEvent;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2021-03-27 18:33:36
 * @since
 */
@Component
@Slf4j
public class SmsListener {

	/**
	 * 发送短信
	 */
	@EventListener(OrderSuccessEvent.class)
	public void sendSms() {
		log.info("发送短信...");
		log.info("异步执行发送短信的业务逻辑....");
	}
}
