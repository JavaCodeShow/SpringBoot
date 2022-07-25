package com.jf.rocketmqstudy.mq.listener.job;

/**
 * 类作用描述
 *
 * @author 江峰
 * @since 2021/7/15
 */

// @Slf4j
// @Component
// @RocketMQMessageListener(topic = "xxl-job-ms", selectorExpression = "ORDER_CANCEL", consumerGroup = "rocketmq-consumer")
// public class JobListener implements RocketMQListener<String> {
//
//     @Override
//     public void onMessage(String message) {
//         log.info("Receive message：" + message);
//         // throw new ServiceException("200", "消息消费失败");
//     }
// }