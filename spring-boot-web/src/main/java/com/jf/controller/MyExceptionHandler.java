package com.jf.controller;

import com.jf.exception.UserNotExitException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 潇潇暮雨
 * @create 2018-09-30   20:56
 */
@ControllerAdvice
public class MyExceptionHandler {

    // 要加ResponseBody，因为返会的是一个json字符串
//    @ResponseBody
    @ExceptionHandler(UserNotExitException.class)
    public String handler(Exception e, HttpServletRequest request){
        Map map = new HashMap<String,Object>();
        map.put("code","有一行代码错了");
        map.put("message","别睡了，起床改bug了！");
        request.setAttribute("javax.servlet.error.status_code",404);
        return "forward:/error";
    }

}
