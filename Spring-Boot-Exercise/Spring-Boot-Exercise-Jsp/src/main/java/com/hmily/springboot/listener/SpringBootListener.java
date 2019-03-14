package com.hmily.springboot.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by zyzhmily on 2019/3/14.
 */
@WebListener
public class SpringBootListener implements ServletRequestListener{

    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest request= (HttpServletRequest) sre.getServletRequest();
        ServletContext servletContext=request.getServletContext();
        servletContext.log("SpringBootListener Destroyed");
    }

    public void requestInitialized(ServletRequestEvent sre) {

        HttpServletRequest request= (HttpServletRequest) sre.getServletRequest();
        ServletContext servletContext=request.getServletContext();
        servletContext.log("SpringBootListener Initialized");

    }


}
