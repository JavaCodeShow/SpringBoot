package com.jf;

import com.jf.factory.PersonFactory;
import com.jf.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebApplicationTests {

    @Autowired
    private OrderService orderService;

    // @Autowired()
    // @Qualifier("baseAsyncExecutor")
    // private ThreadPoolTaskExecutor baseAsyncExecutor;

    @Test
    public void testSpringEvent() {
        orderService.order();
    }


    @Test
    public void testPersonFactory() {
        PersonFactory.match(1).say();
        PersonFactory.match(2).say();
    }

    @Test
    public void testThreadPool() {
        // baseAsyncExecutor.execute(() -> {
        //     System.out.println("hello");
        // });
        hello();
    }

    @Async("baseAsyncExecutor")
    void hello() {
        System.out.println("hello");
    }

}
