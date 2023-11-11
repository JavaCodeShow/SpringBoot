package com.jf.rocketmqstudy.mq.delayed;

import com.jf.common.utils.time.LocalDateTimeUtil;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * 发送延时消息
 *
 * @author 江峰
 * @date 2020/8/8 16:49
 */
public class ScheduledMessageProducer {
    public static void main(String[] args) throws Exception {

        DefaultMQProducer producer = new DefaultMQProducer(
                "ExampleProducerGroup");
        producer.setNamesrvAddr("172.28.88.249:9876");
        producer.start();

        int totalMessagesToSend = 2;

        for (int i = 0; i < totalMessagesToSend; i++) {

            Message message = new Message("topic1", "tagA",
                    ("Hello scheduled message " + i).getBytes());

            // 设置延时等级2,这个消息将在5s之后发送(现在只支持固定的几个时间,详看delayTimeLevel)
            // private String messageDelayLevel = "1s 5s 10s 30s 1m 2m 3m 4m 5m
            // 6m 7m 8m 9m 10m 20m 30m 1h 2h";
            // level == 0，消息为非延迟消息
            // 1<=level<=maxLevel，消息延迟特定时间，例如level==1，延迟1s
            // level > maxLevel，则level== maxLevel，例如level==20，延迟2h

            message.setDelayTimeLevel(3);
            System.out.println(
                    "发送前时间 = " + LocalDateTimeUtil.getLocalDateTimeStr());
            SendResult send = producer.send(message);
            System.out.println(send);
            System.out.println(
                    "发送后时间 = " + LocalDateTimeUtil.getLocalDateTimeStr());
        }

        producer.shutdown();
    }
}
