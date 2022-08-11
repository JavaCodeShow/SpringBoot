package com.jf.template.controller;

import com.jf.common.aspect.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2021-05-22 19:11:23
 * @since
 */
@RestController
@Slf4j
public class IndexController {

    @GetMapping("/")
    public BaseResult index() {
        return BaseResult.success("Hello Spring Boot");
    }
}
