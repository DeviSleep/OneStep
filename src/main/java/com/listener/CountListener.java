package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by des on 2017/7/8.
 * 监听器  监听当前在线人数
 */
public class CountListener implements HttpSessionListener {

    private int count = 0;

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        count++;
        HttpSession session = httpSessionEvent.getSession();
        ServletContext sct = session.getServletContext();
        sct.setAttribute("count",count);

    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        count--;
        HttpSession session = httpSessionEvent.getSession();
        ServletContext sct = session.getServletContext();
        sct.setAttribute("count",count);
    }
}
