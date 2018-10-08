package com.jf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * @author 潇潇暮雨
 * @create 2018-09-29   22:12
 */

@Controller
public class LoginController {

    @RequestMapping(value={"/user/login"},method = {RequestMethod.POST})
//    @PostMapping("/user/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password") String password,
                        HttpSession session){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginUser",username);
            return "dashboard";
        }else{
            return "login";
        }
    }
}
