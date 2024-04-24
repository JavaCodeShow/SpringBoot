package com.jf.disruptor.message;

import com.alibaba.fastjson.JSON;
import com.lmax.disruptor.EventHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class HelloEventHandler implements EventHandler<MessageModel> {

    private static final AtomicInteger indexGet = new AtomicInteger(0);

    @Override
    public void onEvent(MessageModel event, long sequence, boolean endOfBatch) throws Exception {
        log.info("共收到消息数量: {}", indexGet.incrementAndGet());
        try {
            if (event == null) {
                return;
            }
            log.info("本次需要处理的消息:{}", JSON.toJSONString(event));

            // 这里停止5s,模拟作业执行时长
            TimeUnit.SECONDS.sleep(2);
            log.info("信息类型{}处理结束", event.getType());
        } catch (Exception e) {
            log.error("消费者处理消息失败,失败原因: ", e);
        }
    }
}