package com.jf.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 潇潇暮雨
 * @create 2019-09-23   23:09
 */
public class MyFilter implements Filter {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.debug("过滤器。。。。。");

        // 过滤完了之后需要放行
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
