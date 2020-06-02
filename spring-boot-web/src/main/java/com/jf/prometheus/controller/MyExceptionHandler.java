package com.jf.prometheus.controller;

import com.jf.exception.UserNotExitException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 潇潇暮雨
 * @create 2018-09-30   20:56
 */

// 加上@ControllerAdvice注解这个类就成为了全局异常处理类
@ControllerAdvice
@ResponseBody
public class MyExceptionHandler {

    // 拦截所有(UserNotExitException)异常, 一般情况下一个方法特定处理一种异常
    @ExceptionHandler(UserNotExitException.class)
    public ResponseEntity<String> handler(Exception e) {
        return ResponseEntity.status(404).body("后端出现了UserNotExitException");
    }
/*
    // 拦截所有异常, 这里只是为了演示，一般情况下一个方法特定处理一种异常
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handler1(Exception e) {
        return ResponseEntity.status(404).body("后端出现了异常");
    }*/

}
