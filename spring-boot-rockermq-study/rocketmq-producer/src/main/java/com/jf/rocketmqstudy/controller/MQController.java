package com.jf.rocketmqstudy.controller;


import com.jf.model.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述: producer
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
    public CommonResult<Boolean> hello() {

        log.info("send ok");

        for (int i = 0; i < 5; i++) {
            rocketMQTemplate.syncSend("topicA:tagA1", "orderId-111");
            rocketMQTemplate.syncSend("topicA:tagB1", "orderId-222");
        }

        return CommonResult.success(Boolean.TRUE);
    }
}
