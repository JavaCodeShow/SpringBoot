package com.jf;

import com.jf.factory.PersonFactory;
import com.jf.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void testSpringEvent() {
        orderService.order();
    }


    @Test
    public void testPersonFactory() {
        PersonFactory.match(1).say();
        PersonFactory.match(2).say();
    }

}
