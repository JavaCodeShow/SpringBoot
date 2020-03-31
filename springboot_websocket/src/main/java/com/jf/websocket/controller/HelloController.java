package com.jf.websocket.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 江峰
 * @create 2020-03-31   14:56
 */

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
