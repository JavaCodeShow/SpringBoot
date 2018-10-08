package com.jf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 潇潇暮雨
 * @create 2018-10-05   10:36
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    @ResponseBody
    public String hello(){
        return "hello world";
    }

    @RequestMapping("/success")
    public String success(Map map) {
        map.put("hello", "你好啊");
        return "success";
    }
    @RequestMapping("/hello")
    public String success() {
        return "hello";
    }

}
