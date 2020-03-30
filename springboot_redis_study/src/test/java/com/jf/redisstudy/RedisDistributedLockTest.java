package com.jf.redisstudy;

import com.jf.redisstudy.distributedLock.RedisDistributedLock;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

/**
 * @author 江峰
 * @create 2020-03-30   16:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDistributedLockTest {
    static int n = 500;
    public static void secskill() {
        System.out.println(--n);
    }

    public static void main(String[] args) {
        Runnable runnable = () -> {
            RedisDistributedLock lock = null;
            String unLockIdentify = null;
            try {
                Jedis conn = new Jedis("139.224.103.236",6379);
                lock = new RedisDistributedLock(conn, "test1");
                unLockIdentify = lock.acquire();
                System.out.println(Thread.currentThread().getName() + "正在运行");
                secskill();
            } finally {
                if (lock != null) {
                    lock.release(unLockIdentify);
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
    }
}
