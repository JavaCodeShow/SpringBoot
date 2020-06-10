package com.jf.prometheus.controller;

import com.jf.prometheus.service.RegistrationService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author 江峰
 * @date 2020/6/5 11:26
 * @Email: jiangfeng@jumstc.com
 * @description
 */
@Controller
public class ServiceController {

    @Resource
    private RegistrationService registrationService;


    // public List getService() {
    //     return registrationService.getService()
    // }
}
