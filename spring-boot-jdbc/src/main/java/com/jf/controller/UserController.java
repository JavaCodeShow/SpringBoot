package com.jf.controller;

import com.jf.mapper.UserMapper;
import com.jf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 潇潇暮雨
 * @create 2018-10-04   14:35
 */
@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/user/{id}")
    @ResponseBody
    public User getUserById(@PathVariable Integer id){
        User user = userMapper.getUserById(id);
        return user;
    }

    @RequestMapping("/user")
    @ResponseBody
    public String insertUser(User user){
        userMapper.insertUser(user);
        return "success";
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public String deleteUserById(@RequestParam(name = "id",defaultValue = "1") Integer id){
        userMapper.deleteUserById(id);
        return "delete success";
    }

}
