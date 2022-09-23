package com.jf.sharding.jdbc.controller;

import com.jf.common.utils.aspect.log.MethodLogger;
import com.jf.common.utils.utils.id.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 江峰
 * @create 2021-05-17 14:54
 */
@RestController
@Slf4j
public class HelloController {

    @RequestMapping("/")
    @MethodLogger(apiId = "62a30deb3785be2a4c58cde9")
    public String hello() {
        return "hello sharding jdbc is running";
    }

}
