package com.jf.disruptor.message;

import com.lmax.disruptor.RingBuffer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DisruptorMqService {

    @Autowired
    private RingBuffer<MessageModel> messageModelRingBuffer;

    public void sayHelloMq(int type, String message) {
        // 获取下一个Event槽的下标
        long sequence = messageModelRingBuffer.next();
        try {
            // 给Event填充数据
            MessageModel event = messageModelRingBuffer.get(sequence);
            event.setType(type);
            event.setMessage(message);
            log.info("开始发送消息,第{}条消息,消息内容={}", type, message);

        } catch (Exception e) {
            log.info("failed to add event to messageModelRingBuffer,错误原因:", e);
        } finally {
            // 发布Event，激活观察者去消费，将sequence传递给改消费者
            // 注意最后的publish方法必须放在finally中以确保必须得到调用；如果某个请求的sequence未被提交将会堵塞后续的发布操作或者其他的producer
            messageModelRingBuffer.publish(sequence);
        }
    }
}