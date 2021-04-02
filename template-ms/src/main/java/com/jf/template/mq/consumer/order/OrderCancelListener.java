package com.jf.template.mq.consumer.order;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述: 监听订单取消的MQ消息
 *
 * @author: 江峰
 * @create: 2021-04-02 17:34
 * @since: 2.22.1
 */

@Slf4j
@Component
@RocketMQMessageListener(topic = "template-ms", selectorExpression = "ORDER_CANCEL", consumerGroup = "template-ms")
public class OrderCancelListener implements RocketMQListener<String> {

	@Override
	public void onMessage(String message) {
		log.info("Receive message：" + message);
	}

}