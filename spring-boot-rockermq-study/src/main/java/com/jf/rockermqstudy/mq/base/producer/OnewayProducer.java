package com.jf.rockermqstudy.mq.base.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 单向发送消息
 *
 * @author 江峰
 * @date 2020/8/7 18:01
 */
public class OnewayProducer {
    public static void main(String[] args) throws Exception {
        // 实例化消息生产者Producer
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        // 设置NameServer的地址
        producer.setNamesrvAddr("139.224.103.236:9876");
        // 启动Producer实例
        producer.start();
        for (int i = 0; i < 1000; i++) {
            // 创建消息，并指定Topic，Tag和消息体
            Message msg = new Message("topic1",
                    "tag1",
                    ("Hello RocketMQ " + "单向发送消息").getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            // 发送单向消息，没有任何返回结果
            producer.sendOneway(msg);
            System.out.println(i);
        }
        // 如果不再发送消息，关闭Producer实例。
        producer.shutdown();
    }
}
