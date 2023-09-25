package com.jf.websocket.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 江峰
 */

@RestController
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "hello";
    }
}
