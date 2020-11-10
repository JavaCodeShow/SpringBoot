package com.jf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author 潇潇暮雨
 * @create 2018-10-05   10:36
 */
@Controller
public class HelloController {

    @Value("${book.name}")
    private String bookName;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello world + " + "boob.name = " + bookName ;
    }

    @RequestMapping("/success")
    public String success(Map map) {
        map.put("hello", "你好啊");
        return "success";
    }
}
