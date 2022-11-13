package com.jf.template.controller;

import com.jf.model.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述: test producer send message
 *
 */
@RestController
@Slf4j
public class MQController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @RequestMapping("/send")
    public CommonResult hello() {

        log.info("send ok");
        // destination formats: `topicName:tags
        rocketMQTemplate.syncSend("template-ms:ORDER_CANCEL", "orderId-111");

        return CommonResult.success();
    }
}
