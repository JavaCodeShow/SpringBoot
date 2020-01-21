package com.jf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 潇潇暮雨
 * @create 2018-10-07   10:07
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {


    // @Autowired
    // private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis() {
        // stringRedisTemplate.opsForValue().append("1","hello");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            stringRedisTemplate.opsForValue().set("user:" + i, i + "");
        }
        long end = System.currentTimeMillis();
        System.out.println("时间 = " + (end - start) + "(毫秒)");
        // stringRedisTemplate.opsForValue().set("id:1", "v1");
        // stringRedisTemplate.opsForValue().set("id:2", "v2");
        // stringRedisTemplate.opsForValue().set("id:3", "v3");
        // Object o = stringRedisTemplate.keys("*");
        // System.out.println();

        // int id = 6;
        // User user = userMapper.getUserById(id);
//        stringRedisTemplate.opsForValue().set("string","hello");
//        redisTemplate.opsForValue().set("name","jiangfeng");
//        redisTemplate.opsForValue().set(id +"",user);
//        System.out.println(redisTemplate.opsForValue().get(id + ""));
    }
}
