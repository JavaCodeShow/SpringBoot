package com.jf.rocketmqstudy.mq.listener;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-04-02 15:53
 * @since: 2.22.1
 */
// @Slf4j
// @Component
// @RocketMQMessageListener(topic = "wms", selectorExpression = "ORDER_CANCEL", consumerGroup = "rocketmq-consumer")
// public class OrderCancelListener implements RocketMQListener<String> {
//
//     @Override
//     public void onMessage(String message) {
//         log.info("Receive message：" + message);
//         // throw new ServiceException("200", "消息消费失败");
//     }
// }