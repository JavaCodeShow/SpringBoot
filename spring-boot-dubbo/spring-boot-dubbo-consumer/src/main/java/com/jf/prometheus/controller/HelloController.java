package com.jf.prometheus.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jf.service.ProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 潇潇暮雨
 * @create 2018-10-08 21:19
 */
@Controller
public class HelloController {

    /**
     * @Reference(url = "127.0.0.1:20880") dubbo直连。绕过注册中心
     * mock：请求超时时对服务进行降级处理。需要写一个mock类。
     */
    @Reference(mock = "true", timeout = 3, retries = 3)
    private ProviderService providerService;

    @RequestMapping("/abc")
    @ResponseBody
    public String hello() {
        System.out.println("I am consumer");
        String str = providerService.sendHello();
        System.out.println(str);
        return "success";
    }
}
