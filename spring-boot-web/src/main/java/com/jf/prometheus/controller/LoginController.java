package com.jf.prometheus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author 潇潇暮雨
 * @create 2018-09-29   22:12
 */

@Controller
public class LoginController {

    @RequestMapping(value = {"/user/login"}, method = {RequestMethod.POST})
//    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session) {
        return null;
    }
}
