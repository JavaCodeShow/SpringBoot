package com.jf.template.controller;

import com.jf.model.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 江峰
 */
@RestController
@Slf4j
public class IndexController {

    @GetMapping("/")
    public CommonResult index() {
        return CommonResult.success("Hello Spring Boot");
    }
}
