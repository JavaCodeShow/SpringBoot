package com.jf.mybatisstudy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisstudyApplicationTests {
    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() {
    }

    @Test
    public void hello() throws SQLException {
        System.out.println("数据库：" + dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}
