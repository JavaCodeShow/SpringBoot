package com.jf.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author 潇潇暮雨
 * @create 2018-10-08   21:34
 */

@Component
@Service(interfaceClass = ProviderService.class) // 将服务发布出去
public class ProviderServiceImpl implements ProviderService {

    @Override
    public String sendHello() {
        System.out.println("hello dubbo");
        return "I am provider";
    }
}
