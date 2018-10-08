package com.jf;

import com.jf.bean.Dog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootConfigAutoconfigApplicationTests {

    @Autowired
    private ApplicationContext ac;

    @Test
    public void contextLoads() {
        System.out.println(ac.containsBean("dog"));
    }

}
