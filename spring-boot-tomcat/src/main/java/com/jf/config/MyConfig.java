package com.jf.config;

import com.jf.servlte.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 潇潇暮雨
 * @create 2018-10-01   13:50
 */
@Configuration
//@PropertySource("classpath:person.properties")
@ImportResource(locations = {"classpath:beans.xml"})
public class MyConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/aa").setViewName("hello");
    }

    // 添加servlet组件
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet());
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/myServlet");
        return registrationBean;
    }
}
