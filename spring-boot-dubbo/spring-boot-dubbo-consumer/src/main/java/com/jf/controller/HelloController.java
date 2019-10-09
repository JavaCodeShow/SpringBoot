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

    @Reference
    private ProviderService providerService;

    @RequestMapping("/abc")
    @ResponseBody
    public String hello(){
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        providerService.sendHello();
        return "success";
    }
}
