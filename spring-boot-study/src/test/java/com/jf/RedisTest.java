package com.jf;

import com.jf.mapper.UserMapper;
import com.jf.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 潇潇暮雨
 * @create 2018-10-10   9:40
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValue() {
//        redisTemplate.opsForValue().set("name", "张三");
        int id = 6;
        User user = userMapper.getUserById(id);
        redisTemplate.opsForValue().set(id + "",user);
    }

    @Test
    public void getValue(){
//        User user =(User) redisTemplate.opsForValue().get("6");
//        System.out.println(user);
        System.out.println(redisTemplate.opsForValue().get("6"));
    }

}
