package com.jf.controller;

import com.jf.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 潇潇暮雨
 * @create 2018-09-29   9:21
 */
@RestController
public class HelloController {


    @Autowired
    private Person person;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello : " + person.getName();
    }

}
