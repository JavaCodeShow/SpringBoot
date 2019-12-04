package com.jf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 潇潇暮雨
 * @create 2019-09-28   20:27
 */
@RestController
public class HelloController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/hello")
    public List<Map<String, Object>> hello() {
        String sql = "select * from user";
        List<Map<String, Object>> users = jdbcTemplate.queryForList(sql);
        System.out.println(users);
        return users;
    }

    @PostMapping("/")
    public void add() {
        int count = 1000;
        for (int i = 0; i < count; i++) {
            String sql = "insert into user (name,password) values (" + i + "" + i + "," + i + "" + i + "" + i + ")";
            jdbcTemplate.execute(sql);
        }
    }
}
