package com.jf.prometheus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 江峰
 * @date 2020/6/2 9:23
 * @Email: jiangfeng@jumstc.com
 * @description
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "prometheus";
    }
}
