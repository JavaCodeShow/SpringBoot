package com.jf.controller;

import com.jf.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 潇潇暮雨
 * @create 2018-10-01   11:12
 */
@Controller
public class HelloController {

    @Autowired
    private Person person;

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("message","学习使我快乐");
        return "hello";
    }

    @RequestMapping("/abc")
    @ResponseBody
    public String fun(){
        return "hello : " + person.getName() + " : " + person.getAge();
    }
}
