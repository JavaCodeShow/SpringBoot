package com.jf.rocketmqstudy.mq.transaction;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @author 江峰
 * @date 2020/8/18 17:09
 */
public class TransactionProducer {
	public static void main(String[] args)
			throws MQClientException, InterruptedException {

		// 创建事务监听器
		TransactionListener transactionListener = new TransactionListenerImpl();
		// 创建消息生产者
		TransactionMQProducer producer = new TransactionMQProducer("group6");
		producer.setNamesrvAddr("139.224.103.236:9876");
		// 生产者这是监听器
		producer.setTransactionListener(transactionListener);
		// 启动消息生产者
		producer.start();
		for (int i = 1; i <= 5; i++) {
			try {
				Message msg = new Message("TransactionTopicTest",
						"transactionTag", "msg-" + i, ("Hello RocketMQ " + i)
								.getBytes(RemotingHelper.DEFAULT_CHARSET));
				SendResult sendResult = producer.sendMessageInTransaction(msg,
						null);
				// System.out.printf("%s%n", sendResult);
				TimeUnit.SECONDS.sleep(1);
			} catch (MQClientException | UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
		producer.shutdown();
	}
}