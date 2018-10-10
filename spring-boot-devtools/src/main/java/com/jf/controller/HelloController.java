package com.jf.controller;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 潇潇暮雨
 * @create 2018-10-08   21:59
 */
@Controller
public class HelloController {

    @RequestMapping("/a")
    @ResponseBody
    public String hello(){
        return "热部署";
    }
}
