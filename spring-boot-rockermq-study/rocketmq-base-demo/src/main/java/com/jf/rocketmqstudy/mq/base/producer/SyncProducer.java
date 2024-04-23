package com.jf.rocketmqstudy.mq.base.producer;

import com.jf.common.utils.time.LocalDateTimeUtil;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 发送同步消息
 *
 * @author 江峰
 * @date 2020/8/5 11:38
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        // 实例化消息生产者Producer
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        // 设置NameServer的地址
        producer.setNamesrvAddr("172.31.128.22:9876");
        // 启动Producer实例
        producer.start();
        // producer.setSendMessageWithVIPChannel(false);
        for (int i = 0; i < 1; i++) {
            // 创建消息，并指定Topic，Tag和消息体
            Message msg = new Message("CSS", "ORDER_CANCEL",
                    ("Hello RocketMQ " + i)
                            .getBytes(RemotingHelper.DEFAULT_CHARSET));
            // 发送消息到一个Broker
            System.out.println(LocalDateTimeUtil.getLocalDateTimeStr());
            msg.setKeys("666");
            SendResult sendResult = producer.send(msg);
            // 通过sendResult返回消息是否成功送达
            System.out.printf("%s%n", sendResult);
            System.out.println(LocalDateTimeUtil.getLocalDateTimeStr());

        }
        System.out.println("main");
        // 如果不再发送消息，关闭Producer实例。
        producer.shutdown();
        System.out.println("exit");
        System.exit(0);
    }
}
