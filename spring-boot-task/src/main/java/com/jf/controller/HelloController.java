package com.jf.controller;

import com.jf.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 潇潇暮雨
 * @create 2018-10-08   14:48
 */

@Controller
public class HelloController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        asyncService.hello();
        return "测试异步任务的执行";
    }
}
