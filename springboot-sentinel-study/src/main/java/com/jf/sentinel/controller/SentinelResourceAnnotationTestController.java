package com.jf.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jf.common.utils.time.LocalDateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SentinelResourceAnnotationTestController {

    @SentinelResource(value = "annotation_test", blockHandler = "exceptionHandler")
    @GetMapping("/annotation_test")
    public String ann() {
        // 使用限流规则
        System.out.println("annotation_test  + " + LocalDateTimeUtil.getLocalDateTimeStr());
        return "annotation_test";
    }

    public String exceptionHandler(BlockException e) {
        System.out.println("系统繁忙请稍后再试");
        return "系统繁忙请稍后再试";
    }


}
