package com.jf.sentinel.controller;


import com.jf.common.utils.time.LocalDateTimeUtil;
import com.jf.model.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("/")
    public CommonResult<String> index() {
        System.out.println(LocalDateTimeUtil.getLocalDateTimeStr());
        return CommonResult.success("hello sentinel");
    }

}
