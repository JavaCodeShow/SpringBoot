package com.jf.rocketmqstudy.mq.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(topic = "topicA", selectorExpression = "tagA1", consumerGroup = "spring-application-name")
public class TestConsumer implements RocketMQListener<String>/*, RocketMQPushConsumerLifecycleListener */{
    @Override
    public void onMessage(String message) {
        log.info("Receive message：" + message);
        // 业务逻辑处理。。。
    }
    //
    // @Override
    // public void prepareStart(DefaultMQPushConsumer defaultMQPushConsumer) {
    //     defaultMQPushConsumer.setInstanceName("spring-application-name");
    // }
}