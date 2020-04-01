package com.jf.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author 江峰
 * @create 2020-04-01   16:50
 */
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = {"test"}, groupId = "group1", containerFactory = "kafkaListenerContainerFactory")
    public void kafkaListener(String message) {
        System.out.println(message);
    }

}