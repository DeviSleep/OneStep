package com;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by des on 2017/6/29.
 */
public class ActionServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        String uri = req.getRequestURI();
        String action = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
        HttpSession session = req.getSession();
        System.out.println(session.getId());
//        session.setMaxInactiveInterval(10);    //编程式设定session超时

        if (action.equals("login")) {
            String name = req.getParameter("uname");
            String pwd = req.getParameter("pwd");
            String number = req.getParameter("vcode");     //1.获取页面用户输入的验证码
            String code = session.getAttribute("code").toString();      //2.获取服务器端生成的验证码字符串，绑定在seesion中
            //3.如果验证码比较，用户名或密码不对  则不能跳转到主页
            if (number.equals(code) && name.equals("111") && pwd.equals("111")) {
                session.setAttribute("uname", name);
                resp.sendRedirect("index.jsp");               //重定向
            } else {
                req.setAttribute("msg", "用户名密码有误！");
                req.getRequestDispatcher("login.jsp").forward(req, resp);     //转发
            }
        }
    }

}
