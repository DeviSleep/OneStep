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
public class CountServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html;charset=utf-8");
        PrintWriter out = res.getWriter();
        //获取session对象
        HttpSession session = req.getSession();
        System.out.println(session.getId());
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 1;
        } else {
            count++;
        }

        session.setAttribute("count", count);
        out.println("这是第" + count + "次访问");
        out.close();

    }

}
