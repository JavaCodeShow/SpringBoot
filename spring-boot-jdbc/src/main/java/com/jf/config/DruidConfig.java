package com.jf.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 潇潇暮雨
 * @create 2018-10-04   9:27
 */
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource datasource(){
        return new DruidDataSource();
    }

    // 配置druid的监控
    // 1.配置一个管理后台的serlvet
    @Bean
    public ServletRegistrationBean statViewServlet(){
    /*
        "loginUsername";
         "loginPassword";
         "allow";
         "deny";
     */
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String, String> map = new LinkedHashMap();
        map.put("loginUsername","root");
        map.put("loginPassword","123456");
        map.put("allow","");// 默认就是允许所有访问
        map.put("deny","192.168.135.129"); // 禁止某个访问
        registrationBean.setInitParameters(map);
        return registrationBean;

    }

    // 2、配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap();
        initParams.put("exclusions","*.css,*.js,/druid/*");
        registrationBean.setInitParameters(initParams);
        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        return registrationBean;

    }

}
