package com.jf.rocketmqstudy.mq.listener.job;

import com.jf.mq.core.annotation.MQMessageListener;
import com.jf.mq.core.consumer.listenre.AbstractNormalMQListener;
import com.jf.mq.core.domain.constant.TopicConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 类作用描述
 *
 * @author 江峰
 * @since 2021/7/15
 */

@Slf4j
@Component
@MQMessageListener(topic = TopicConstant.SHOW_TOPIC_NAME, tag = "SHOW_CLOSE", classType = String.class)
public class JobListener extends AbstractNormalMQListener<String> {

    @Override
    public boolean doConsume(String message) {
        log.info("接受到消息JobListener，message={}", message);
        return true;
    }

}