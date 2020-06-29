package com.jf.controller;

import com.jf.entities.Employee;
import com.jf.exception.UserNotExitException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ValidationException;
import java.io.IOException;
import java.util.Map;

/**
 * @author 潇潇暮雨
 * @create 2018-09-29   16:26
 */

@RestController
@Validated
public class HelloController {

    @RequestMapping("/user/{username}")
    public String user(@PathVariable("username") String username) {
        if (!username.equals("tom")) {
            throw new UserNotExitException("user is not exit");
        }
        return "user是存在的";
    }

    @RequestMapping(value = {"/", "index.html"})
    public String index() {
        return "login";
    }

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Object name = session.getAttribute("name");
        System.out.println(name);
        session.setAttribute("name", "jf");
        String sessionId = session.getId();
        String res = "";
        if (session.isNew()) {
            res = "session创建成功，session的id是：" + sessionId;
        } else {
            res = "服务器已经存在该session了，session的id是：" + sessionId;
        }
        return res;
    }

    @RequestMapping("/success")
    public String success(Map map) {
        int i = 1 / 0;
        map.put("hello", "你好啊");
        return "success";
    }

    @RequestMapping("/test")
    public void fun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/user/login").forward(request, response);
    }

    @RequestMapping("/abc")
    public Employee success(@RequestBody @Validated Employee employee, BindingResult bindingResult) {
        validData(bindingResult);
        return employee;
    }

    private void validData(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuffer sb = new StringBuffer();
            for (ObjectError error : bindingResult.getAllErrors()) {
                sb.append(((FieldError) error).getField() + "" + error.getDefaultMessage());
            }
            throw new ValidationException(sb.toString());
        }
    }
}
