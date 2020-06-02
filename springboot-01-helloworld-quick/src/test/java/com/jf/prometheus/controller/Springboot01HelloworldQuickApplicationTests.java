package com.jf.prometheus.controller;

import com.jf.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01HelloworldQuickApplicationTests {

    @Autowired
    private Person person;

    @Autowired
    private ApplicationContext ac;

    @Test
    public void testHelloService(){
//        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans.xml");
        boolean b = ac.containsBean("helloService1");
        System.out.println(b);
    }

    @Test
    public void contextLoads() {
        System.out.println(person);
    }

}
