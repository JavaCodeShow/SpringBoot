package com.jf.config;

import com.jf.filter.MyFilter;
import com.jf.servret.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 潇潇暮雨
 * @create 2018-10-05   15:38
 */

@Configuration
public class MyWebConfig {

    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean<MyServlet> registrationBean = new ServletRegistrationBean<>();
        registrationBean.setServlet(new MyServlet());
        registrationBean.addUrlMappings("/myServlet");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        return registrationBean;
    }

}
