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
        // 定义用于事件处理的线程池，
        // Disruptor通过java.util.concurrent.ExecutorSerivce提供的线程来触发consumer的事件处理// 指定事件工厂
        MessageEventFactory factory = new MessageEventFactory();

        // 指定ringbuffer字节大小，必须为2的N次方（能将求模运算转为位运算提高效率），否则将影响效率
        int bufferSize = 1024 * 256;

        //决定一个消费者如何等待生产者将Event置入Disruptor,其所有实现都是针对消费者线程的 。
        //BlockingWaitStrategy：最低效的策略，但其对CPU的消耗最小，并且在各种部署环境中能提供更加一致的性能表现，内部维护了一个重入锁ReentrantLock和Condition
        //SleepingWaitStrategy: 性能表现和com.lmax.disruptor.BlockingWaitStrategy差不多，对CPU的消耗也类似，但其对生产者线程的影响最小，
// 　　　　　　　　　　适合用于异步日志类似的场景；是一种无锁的方式
        //YieldingWaitStrategy: 性能最好，适合用于低延迟的系统；在要求极高性能且事件处理线程数小于CPU逻辑核心树的场景中，推荐使用此策略；
// 　　　　　　　　　　例如，CPU开启超线程的特性；也是无锁的实现，只要是无锁的实现，signalAllWhenBlocking()都是空实现

        //SINGLE 采用单消费者模式
        //MULTI 多个消费者，每个消费者消费不同数据。也就是说每个消费者竞争数据，竞争到消费，其他消费者没有机会
        Disruptor<MessageModel> disruptor = new Disruptor<>(
                factory,
                bufferSize,
                Executors.defaultThreadFactory(),
                ProducerType.SINGLE,
                new BlockingWaitStrategy());

        // 设置事件业务处理器---消费者
        disruptor.handleEventsWith(new HelloEventHandler());

        // 启动disruptor线程
        disruptor.start();

        // 获取ringbuffer环，用于接取生产者生产的事件

        return disruptor.getRingBuffer();
    }

}