package com.jf.disruptor.message;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;

@Configuration
public class MessageQueueManager {

    @Bean
    public RingBuffer<MessageModel> messageModelRingBuffer() {

        MessageEventFactory factory = new MessageEventFactory();

        int bufferSize = 1024 * 256;

        Disruptor<MessageModel> disruptor = new Disruptor<>(
                factory,
                bufferSize,
                Executors.defaultThreadFactory(),
                ProducerType.MULTI,
                new BlockingWaitStrategy());

        disruptor.handleEventsWith(new HelloEventHandler());

        disruptor.start();

        return disruptor.getRingBuffer();
    }

}