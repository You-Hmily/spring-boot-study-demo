package com.hmily.springboot.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zyzhmily on 2019/3/14.
 */
@WebFilter(servletNames = "myServlet")
public class MyFilter extends OncePerRequestFilter{


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        ServletContext servletContext=httpServletRequest.getServletContext();

        servletContext.log("myServlet was Filtered!!");

        filterChain.doFilter(httpServletRequest,httpServletResponse);

    }
}
