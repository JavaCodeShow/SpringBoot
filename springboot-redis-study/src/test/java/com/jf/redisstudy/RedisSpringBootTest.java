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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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

    @Test
    public void distributedLockTest() throws InterruptedException {
        // ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        int nThreads = 5;
        ExecutorService es = Executors.newFixedThreadPool(nThreads);
        for (int i = 0; i < 5; i++) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " ：准备去获取锁 ");
                    Boolean flag = redisTemplate.opsForValue().setIfAbsent("lock", "jf", 3, TimeUnit.SECONDS);
                    System.out.println("hello");
                    System.out.println("flag = " + flag);
                    if (flag) {
                        System.out.println(Thread.currentThread().getName() + " ：获取锁了，开始执行 ");
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            redisTemplate.delete("lock");
                            System.out.println(Thread.currentThread().getName() + " ：释放锁 ");
                        }
                        System.out.println(Thread.currentThread().getName() + " ：执行结束 ");
                    } else {
                        System.out.println(Thread.currentThread().getName() + " ：没有获取到锁 ");
                    }
                }
            });
        }
        // es.shutdown();

    }
}
