package com.jf.controller;

import com.jf.bean.User;
import com.jf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author 江峰
 * @create 2019-09-29   10:44
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllUser() {
        List<User> userList = userService.getAllUser();
        return userList;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user, HttpServletRequest request) {
        System.out.println(request.getQueryString());
        System.out.println("user" + user);
        userService.addUser(user);
        return user;
    }
}
