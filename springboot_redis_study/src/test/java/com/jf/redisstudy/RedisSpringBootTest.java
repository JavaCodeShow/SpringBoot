package com.jf.redisstudy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Set;

/**
 * @author 江峰
 * @create 2020-03-21   10:58
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisSpringBootTest {

    static {
        System.out.println("开始单元测试");
    }

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 操作String类型
     */
    @Test
    public void stringSet() {
        // long start = System.currentTimeMillis();
        // long end = System.currentTimeMillis();
        // System.out.println("插入redis耗时" + (end - start) + " ms");
        ValueOperations ops = redisTemplate.opsForValue();
        long start = System.currentTimeMillis();
        HashMap<String, String> map = new HashMap<>(100000);
        for (int i = 0; i < 100000; i++) {
            map.put("k" + i, "v" + i);
        }
        long end = System.currentTimeMillis();
        System.out.println("插入map耗时" + (end - start) + " ms");
        start = System.currentTimeMillis();
        ops.multiSet(map);
        end = System.currentTimeMillis();
        System.out.println("插入redis耗时" + (end - start) + " ms");
    }


    @Test
    public void getAllKeys() {
        long start = System.currentTimeMillis();
        Set keys = redisTemplate.keys("*");
        long end = System.currentTimeMillis();
        System.out.println("查询redis耗时" + (end - start) + " ms");
        System.out.println("redis中key的个数：" + keys.size());
        redisTemplate.discard();
    }
}
