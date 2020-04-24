package com.jf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jf.service.ProviderService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 潇潇暮雨
 * @create 2018-10-08   21:19
 */
@Controller
public class HelloController {

    // @Reference(url = "127.0.0.1:20880")
    @Reference
    private ProviderService providerService;

    @RequestMapping("/abc")
    @ResponseBody
    public String hello(){
        System.out.println("I am consumer");
        String str = providerService.sendHello();
        System.out.println(str);
        return "success";
    }
}
