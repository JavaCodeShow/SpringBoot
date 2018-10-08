package com.jf;

import com.jf.mapper.UserMapper;
import com.jf.pojo.Cat;
import com.jf.pojo.Dog;
import com.jf.pojo.Person;
import com.jf.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootStudyApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Dog dog;

    @Autowired
    private Cat cat;

    @Autowired(required = false)
    private Person person;

    @Autowired
    private ApplicationContext ac;

    @Test
    public void testMybatis(){
        User user = userMapper.getUserById(6);
        System.out.println(user);
    }

    @Test
    public void contextLoads() {
        System.out.println(ac.containsBean("dog") + " : dog");
        System.out.println(person);
        cat.setName("haha");
        System.out.println(cat);
        System.out.println(dog.getName());
    }

}
