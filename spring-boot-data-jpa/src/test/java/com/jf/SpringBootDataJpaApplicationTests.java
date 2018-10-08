package com.jf;

import com.jf.entity.User;
import com.jf.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDataJpaApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() throws SQLException {
        System.out.println("------------------------------------------");
        User user = new User();
        user.setId(1);
        user.setName("tom");
        user.setSex("man");
        User save = userRepository.save(user);
        System.out.println(save);
        System.out.println("------------------------------------------");
    }

}
