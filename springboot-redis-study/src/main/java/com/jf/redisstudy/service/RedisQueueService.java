package com.jf.redisstudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 描述: redis阻塞队列
 *
 * @author: 江峰
 * @create: 2021-05-21 15:47
 * @since: 2.20.1.1
 */
@Component
public class RedisQueueService {

    @Autowired
    private RedisTemplate redisTemplate;
    int count = 0;

    @PostConstruct
    public void init() {
        new Thread(() -> {
            while (true) {
                System.out.println(count++);
                // list集合 第一个元素为key值，第二个元素为弹出的元素值;当超时返回[null]
                List<Object> obj = redisTemplate
                        .executePipelined(new RedisCallback<Object>() {
                            @Nullable
                            @Override
                            public Object doInRedis(RedisConnection connection)
                                    throws DataAccessException {
                                // 队列没有元素会阻塞操作，直到队列获取新的元素或超时
                                return connection.bLPop(0, "list".getBytes());
                            }
                        }, new StringRedisSerializer());
                System.out.println("接受到redis队列消息：" + obj);
            }

        }).start();

    }

}
