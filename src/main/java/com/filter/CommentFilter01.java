package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by des on 2017/7/7.
 */
public class CommentFilter01 implements Filter {

    private String illegalWord;

    /**
     * 容器启动之后，创建过滤器实例，后调用一次该
     * 容器将已经创建好的FilterConfig对象  作为参数传入，从中获取初始化的配置信息
     *
     * @param filterConfig
     * @throws ServletException
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        illegalWord = filterConfig.getInitParameter("illegalWord");
        System.out.println("Filter01: init is running…… " + illegalWord);
    }

    /**
     * 用于处理请求的主要方法
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String comment = request.getParameter("comment");
        if (comment.indexOf(illegalWord) != -1 || comment.indexOf("damn") != -1) {
            //有敏感词汇
            out.print("<h3>评论内容已关闭！</h3>");
        } else {

            String url = request.getRequestURI();
            System.out.println(url);
            filterChain.doFilter(request, response);     //否则交给其他过滤器 或servlet处理
        }

    }

    /**
     * 用于删除过滤器实例前调用，只执行一次
     */
    public void destroy() {
        System.out.println("Filter01 is destroy");
    }

}
