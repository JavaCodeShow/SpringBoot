package com.jf.rockermqstudy.mq.base.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 发送异步消息
 *
 * @author 江峰
 * @date 2020/8/5 17:39
 */
public class AsyncProducer {
    public static void main(String[] args) throws Exception {
        // 实例化消息生产者Producer
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        // 设置NameServer的地址
        producer.setNamesrvAddr("139.224.103.236:9876");
        // 启动Producer实例

        producer.setRetryTimesWhenSendAsyncFailed(0);
        // producer.setVipChannelEnabled(false);
        producer.start();
        for (int i = 0; i < 1; i++) {
            final int index = i;
            // 创建消息，并指定Topic，Tag和消息体
            Message msg = new Message("topic1",
                    "tag1",
                    "OrderID188",
                    "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
            // SendCallback接收异步返回结果的回调
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%-10d OK %s %n", index,
                            sendResult.getMsgId());
                }

                @Override
                public void onException(Throwable e) {
                    System.out.printf("%-10d Exception %s %n", index, e);
                    e.printStackTrace();
                }
            });

            // SendResult sendResult = producer.send(msg);
            // 通过sendResult返回消息是否成功送达
            // System.out.printf("%s%n", sendResult);
        }
        System.out.println("main");
        // 如果不再发送消息，关闭Producer实例。
		producer.shutdown();
    }
}
