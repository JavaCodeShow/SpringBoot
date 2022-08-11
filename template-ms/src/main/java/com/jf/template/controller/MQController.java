package com.jf.template.controller;

import com.jf.common.aspect.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述: test producer send message
 *
 * @author: 江峰
 * @create: 2021-04-02 15:49
 * @since: 2.22.1
 */
@RestController
@Slf4j
public class MQController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @RequestMapping("/send")
    public BaseResult hello() {

        log.info("send ok");
        // destination formats: `topicName:tags
        rocketMQTemplate.syncSend("template-ms:ORDER_CANCEL", "orderId-111");

        return BaseResult.success();
    }
}
