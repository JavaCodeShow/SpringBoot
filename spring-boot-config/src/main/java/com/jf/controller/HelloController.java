package com.jf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 潇潇暮雨
 * @create 2018-09-28   22:31
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String fun(){
        return "hello word";
    }


}
