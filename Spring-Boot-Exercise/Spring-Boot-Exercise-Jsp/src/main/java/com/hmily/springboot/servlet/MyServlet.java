package com.hmily.springboot.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by zyzhmily on 2019/3/14.
 */
@WebServlet(name = "myServlet",urlPatterns = "/myServlet")
public class MyServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Writer writer=response.getWriter();
        writer.write("<html><body>Hello World!!!</body></html>");
    }





}
