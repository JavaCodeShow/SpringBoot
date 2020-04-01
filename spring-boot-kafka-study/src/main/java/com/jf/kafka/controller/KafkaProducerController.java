package com.jf.kafka.controller;


import com.jf.kafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @author 潇潇暮雨
 * @create 2018-10-05   10:36
 */
@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {

    @Autowired
    private KafkaProducerService producerService;

    @GetMapping("/sync")
    public void sendMessageSync() throws InterruptedException, ExecutionException, TimeoutException {
        producerService.sendMessageSync("test", "同步发送消息测试");
    }

    @GetMapping("/async")
    public void sendMessageAsync() {
        producerService.sendMessageAsync("test", "异步发送消息测试");
    }

}