package com.jf.template.controller;

import com.jf.common.utils.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;

/**
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2021-05-22 19:11:23
 * @since
 */
@RestController
@Slf4j
public class IndexController {

    @Autowired
    @Qualifier("baseAsyncExecutor")
    private Executor baseAsyncExecutor;

    @GetMapping("/")
    public BaseResult index() {
        baseAsyncExecutor.execute(() -> {
            log.info("异步线程");
        });
        return BaseResult.success("Hello Spring Boot");
    }
}
