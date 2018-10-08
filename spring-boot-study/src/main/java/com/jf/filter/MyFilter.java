package com.jf.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 潇潇暮雨
 * @create 2018-10-05   15:42
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter.....initiation");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter.....过滤");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("filter....destroy");
    }
}
