package com.jf.rocketmqstudy.mq.listener;

import com.jf.mq.core.annotation.MQMessageListener;
import com.jf.mq.core.consumer.listenre.AbstractNormalMQListener;
import com.jf.mq.core.domain.constant.TopicConstant;
import com.jf.rocketmqstudy.domain.dto.PersonDTO;
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
@MQMessageListener(topic = TopicConstant.ORDER_TOPIC_NAME, tag = "ORDER_CANCEL", classType = PersonDTO.class)
public class OrderCancelMessageListener extends AbstractNormalMQListener<PersonDTO> {

    @Override
    public boolean doConsume(PersonDTO message) {
        log.info("接受到消息OrderCancelMessageListener，message={}", message.getName());
        return true;
    }

}
