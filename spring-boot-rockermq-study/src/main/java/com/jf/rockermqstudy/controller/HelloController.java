package com.jf.rockermqstudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
    @RequestMapping("/")
    public String hello() {
        log.info("hello world");
        return "Hello RockerMQ ";
    }
}
