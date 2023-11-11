package com.jf.rocketmqstudy.mq.order;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 发送顺序消息
 *
 * @author 江峰
 * @date 2020/8/8 16:10
 */
@Slf4j
public class ProducerInOrder {
    public static void main(String[] args) throws Exception {

        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr("172.28.88.249:9876");
        producer.start();

        // 订单列表
        List<OrderStep> orderList = new ProducerInOrder().buildOrders();

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        for (int i = 0; i < 10; i++) {
            // 加个时间前缀
            String body = dateStr + " Hello RocketMQ " + orderList.get(i);
            Message msg = new Message("topic1", "TagA", body.getBytes());

            SendResult sendResult = producer.send(msg,
                    new MessageQueueSelector() {
                        @Override
                        public MessageQueue select(
                                List<MessageQueue> messageQueueList,
                                Message msg, Object arg) {
                            Long id = (Long) arg; // 根据订单id选择发送queue
                            long index = id % messageQueueList.size();
                            return messageQueueList.get((int) index);
                        }
                    }, orderList.get(i).getOrderId());// 订单id

            System.out.println(
                    String.format("SendResult status:%s, queueId:%d, body:%s",
                            sendResult.getSendStatus(),
                            sendResult.getMessageQueue().getQueueId(), body));
        }

        producer.shutdown();
    }

    /**
     * 订单的步骤
     */
    private static class OrderStep {
        private long orderId;
        private String desc;

        public long getOrderId() {
            return orderId;
        }

        public void setOrderId(long orderId) {
            this.orderId = orderId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "OrderStep{" + "orderId=" + orderId + ", desc='" + desc
                    + '\'' + '}';
        }
    }

    /**
     * 生成模拟订单数据
     */
    private List<OrderStep> buildOrders() {
        List<OrderStep> orderList = new ArrayList<OrderStep>();

        OrderStep orderDemo = new OrderStep();
        orderDemo.setOrderId(111);
        orderDemo.setDesc("创建");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(222);
        orderDemo.setDesc("创建");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(111);
        orderDemo.setDesc("付款");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(333);
        orderDemo.setDesc("创建");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(222);
        orderDemo.setDesc("付款");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(333);
        orderDemo.setDesc("付款");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(222);
        orderDemo.setDesc("完成");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(111);
        orderDemo.setDesc("推送");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(333);
        orderDemo.setDesc("完成");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(111);
        orderDemo.setDesc("完成");
        orderList.add(orderDemo);

        return orderList;
    }
}