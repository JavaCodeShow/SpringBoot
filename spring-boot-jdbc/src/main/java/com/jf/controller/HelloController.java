package com.jf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author 潇潇暮雨
 * @create 2018-10-04   8:51
 */
@Controller
public class HelloController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("/query")
    public Map<String, Object> hello(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user");
        System.out.println(list.get(0).values());
        return list.get(0);
    }
}
