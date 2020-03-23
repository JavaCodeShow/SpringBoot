package com.jf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 潇潇暮雨
 * @create 2018-09-29   20:04
 */
// 实现WebMavConfigurer可以接管SpringMvc，用来取代SpringMvc的默认配置。
@Configuration
//@EnableWebMvc
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // registry.addViewController("/hello1").setViewName("success");
        // registry.addViewController("/dashboard.html").setViewName("dashboard");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/index.html", "/", "/user/login");
//
//    }
}
