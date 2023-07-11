package com.jf.redisstudy.controller;

import com.jf.model.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class IndexController {


    @RequestMapping("/")
    public CommonResult<String> index() {
        return CommonResult.success("spring-boot-apollo-study");
    }


}
