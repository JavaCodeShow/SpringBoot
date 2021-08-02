package com.jf.rocketmqstudy.mq.base.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * 消费者采用广播的方式消费消息，每个消费者消费的消息都是相同的
 *
 * @author 江峰
 * @date 2020/8/7 19:04
 */
public class BroadcastConsumer {
    public static void main(String[] args) throws MQClientException {
        // 实例化消息生产者,指定组名
        String group = "group2";
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(group);
        System.out.println(group);
        // 指定Namesrv地址信息.
        consumer.setNamesrvAddr("139.224.103.236:9876");
        // 订阅Topic
        consumer.subscribe("CSS", "ORDE_CANCEL");
        // 广播模式消费
        consumer.setMessageModel(MessageModel.BROADCASTING);
        // 注册回调函数，处理消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(
                    List<MessageExt> msgs, ConsumeConcurrentlyContext context) {

                System.out.println("线程名字 = " + Thread.currentThread().getName()
                        + "  消息内容 = " + msgs);
                for (MessageExt msg : msgs) {
                    System.out.println(new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 启动消息者
        consumer.start();
        System.out.printf("Consumer Started.%n");

    }
}
