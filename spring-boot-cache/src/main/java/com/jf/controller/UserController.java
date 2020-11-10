package com.jf.controller;

import com.jf.pojo.User;
import com.jf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 潇潇暮雨
 * @create 2018-10-05   21:18
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private String name;

    @GetMapping("/user/{id}")
    @ResponseBody
    public User getUserById(@PathVariable Integer id){
        User user = userService.getUserById(id);
        return user;
    }

    @RequestMapping("/user/delete/{id}")
    public void deleteUserById(@PathVariable Integer id){
        userService.deleteUser(id);
    }

    @RequestMapping(value = "/user/update")
    @ResponseBody
    public User updateUser(User user){
        userService.updateUser(user);
        return user;
    }

    @RequestMapping("/user/save")
    public void insertUser(User user){
        userService.insertUser(user);
    }

}
