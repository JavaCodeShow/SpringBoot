package com.jf.rocketmqstudy.mq.delayed;

import com.jf.common.utils.time.LocalDateTimeUtil;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * 延时消息
 *
 * @author 江峰
 * @date 2020/8/8 16:42
 */
public class ScheduledMessageConsumer {
    public static void main(String[] args) throws Exception {
        cousumeMessage();
    }

    static void cousumeMessage() throws MQClientException {

        // 实例化消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(
                "consumerGroup1");
        // 设置NameServer的地址
        consumer.setNamesrvAddr("localhost:9876");
        // 订阅Topics
        consumer.subscribe("topic1", "tagA");
        // 注册消息监听者
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(
                    List<MessageExt> messages,
                    ConsumeConcurrentlyContext context) {
                for (MessageExt message : messages) {
                    // Print approximate delay time period
                    System.out.println(
                            "时间 = " + LocalDateTimeUtil.getLocalDateTimeStr());
                    System.out.println(
                            "Receive message[msgId=" + message.getMsgId() + "] "
                                    + (System.currentTimeMillis()
                                    - message.getStoreTimestamp())
                                    + "ms later");
                    System.out.println(new String(message.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 启动消费者
        consumer.start();
    }
}
