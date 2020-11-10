package com.jf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author 潇潇暮雨
 * @create 2018-10-05   19:21
 */
@Controller
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/user")
    @ResponseBody
    public Map getUser(){
        return jdbcTemplate.queryForList("select * from user ").get(0);
    }
}
