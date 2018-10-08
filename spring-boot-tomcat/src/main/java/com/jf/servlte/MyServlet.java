package com.jf.servlte;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 潇潇暮雨
 * @create 2018-10-01   13:57
 */
public class MyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("您好啊，国庆节快乐");
    }

    @Override
    protected void doGet(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
        // tomcat默认调用的是doGet方法
        doPost(requset,response);
    }
}
