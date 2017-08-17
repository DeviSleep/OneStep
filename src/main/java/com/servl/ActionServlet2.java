package com.servl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ActionServlet2 extends HttpServlet {

    private static final long serialVersionUID = -4569590875419487616L;

    @Override
    protected void service(HttpServletRequest requset,
                           HttpServletResponse response) throws ServletException, IOException {

        requset.setCharacterEncoding("utf-8");
        int m = 0;
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String uri = requset.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));


        if (path.equals("/get_text")) {
            m++;
            out.println("来自星星的你");
            System.out.println(m);
        } else if ("/post_text".equals(path)) {
            String name = requset.getParameter("uname");
            System.out.println(name);
            out.println("又来一次的：" + name);
        } else if ("/check_name".equals(path)) {
            String name = requset.getParameter("uname");
            if (1 == 1) {
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(name);
            if ("Luffy".equals(name)) {
                out.println("该用户不可用！");
            } else if ("乱码".equals(name)) {
                out.println("该用户不可用！");
            } else {
                out.println("ok");
            }
        } else if ("/getCity".equals(path)) {
            String name = requset.getParameter("name");
            if ("bj".equals(name)) {
                out.println("朝阳,ja;东城,dc");
            } else if ("sh".equals(name)) {
                out.println("静安,ja;黄埔,hp;浦东新,pdx");
            } else if ("gz".equals(name)) {
                out.println("白云,by;番禺,py");
            }
        }


        out.close();
    }


}
