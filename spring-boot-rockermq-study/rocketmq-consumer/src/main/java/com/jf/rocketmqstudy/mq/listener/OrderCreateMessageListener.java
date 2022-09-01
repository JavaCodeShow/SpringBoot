package com.jf.rocketmqstudy.mq.listener;

import com.jf.mq.core.annotation.MQMessageListener;
import com.jf.mq.core.consumer.listener.AbstractNormalMQListener;
import com.jf.mq.core.domain.constant.TopicConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-04-02 15:53
 * @since: 2.22.1
 */

@Component
@Slf4j
@MQMessageListener(topic = TopicConstant.ORDER_TOPIC_NAME, tag = "ORDER_CREATE")
public class OrderCreateMessageListener extends AbstractNormalMQListener<String> {

    @Override
    public boolean doConsume(String message) {
        log.info("接受到消息OrderCancelMessageListener，message={}", message);
        return true;
    }

}
