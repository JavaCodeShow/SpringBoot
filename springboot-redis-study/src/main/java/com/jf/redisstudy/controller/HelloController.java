package com.jf.redisstudy.controller;

import com.jf.common.utils.aspect.log.MethodLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis使用在单元测试里面
 *
 * @author 江峰
 * @create 2020-03-20 14:54
 */
@RestController
@Slf4j
public class HelloController {

    @RequestMapping("/")
    @MethodLogger
    public String hello() {
        return "hello";
    }

}
