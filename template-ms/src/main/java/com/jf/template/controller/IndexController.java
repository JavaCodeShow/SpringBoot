package com.jf.template.controller;

import com.jf.model.result.BaseResult;
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
    public BaseResult index() {
        return BaseResult.success("Hello Spring Boot");
    }
}
