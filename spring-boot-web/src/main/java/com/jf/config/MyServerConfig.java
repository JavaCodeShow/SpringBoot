package com.jf.config;

import com.jf.filter.MyFilter;
import com.jf.listener.MyListener;
import com.jf.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author 潇潇暮雨
 * @create 2018-09-30   22:57
 */
// @Configuration 注解就是用来取代Spring的XML配置文件的
@Configuration
public class MyServerConfig {

    // servlet组件
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

    // 过滤器组件
    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new MyFilter());
        // 设置对哪些路径执行过滤器
        registrationBean.setUrlPatterns(Arrays.asList("/hello", "/success"));
        return registrationBean;
    }

    // 监听器组件

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean(new MyListener());
        return registrationBean;
    }

}
