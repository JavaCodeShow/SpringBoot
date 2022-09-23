package com.jf.sentinel.controller;

import com.jf.common.aspect.result.BaseResult;
import com.jf.common.utils.time.LocalDateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("/")
    public BaseResult<String> index() {
        System.out.println(LocalDateTimeUtil.getLocalDateTimeStr());
        return BaseResult.success("hello sentinel");
    }

}
