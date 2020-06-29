package com.jf.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处理全局异常
 *
 * @author 江峰
 * @date 2020/6/29 16:28
 */

@ControllerAdvice
@Component
@RestController
public class GlobalExceptionHander {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String hello(Object object) {
        return "全局异常";
    }
}
