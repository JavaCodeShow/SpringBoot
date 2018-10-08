package com.jf.controller;

import com.jf.entity.User;
import com.jf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 潇潇暮雨
 * @create 2018-10-04   18:51
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/saveUser")
    @ResponseBody
    public User saveUser(User user){
     /*   User user = new User();
        user.setId(1);
        user.setName("tom");
        user.setSex("man");*/
        User save = userRepository.save(user);
        return save;
    }
}
