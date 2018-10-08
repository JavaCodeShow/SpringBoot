package com.jf;

import com.jf.mapper.UserMapper;
import com.jf.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.cache.RedisCacheManager;
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


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis(){
        int id = 6;
        User user = userMapper.getUserById(id);
//        stringRedisTemplate.opsForValue().set("string","hello");
//        redisTemplate.opsForValue().set("name","jiangfeng");
//        redisTemplate.opsForValue().set(id +"",user);
//        System.out.println(redisTemplate.opsForValue().get(id + ""));
    }
}
