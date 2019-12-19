package com.jf;

import com.alibaba.druid.pool.DruidDataSource;
import com.jf.mapper.AccountMapper;
import com.jf.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJdbcApplicationTests {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println("------------------------------------------------");
        System.out.println(connection);
        System.out.println("------------------------------------------------");
    }

    @Test
    public void getAccountId() {
        Account account = accountMapper.getAccountById(1);
        System.out.println(account);
        System.out.println(account);
        System.out.println(account);
    }

    @Test
    public void insertAccount() {
        for (int i = 0; i < 100000; i++) {
            accountMapper.insertAccount(i);
        }
    }
}
