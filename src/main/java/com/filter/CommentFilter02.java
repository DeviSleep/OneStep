package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by des on 2017/7/8.
 */
public class CommentFilter02 implements Filter {

    private String illegalLength = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        illegalLength = filterConfig.getInitParameter("illegalLength");    //初始化 过滤器参数
        System.out.println("Filter02: is running init……" + illegalLength);
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String str = request.getParameter("comment");
        if (str.length() > Integer.parseInt(illegalLength)) {
            out.println("评论太长，请重试！");
        } else {
            filterChain.doFilter(request, response);
        }

    }

    public void destroy() {
        System.out.println("Filter02 is destroy");
    }
}
