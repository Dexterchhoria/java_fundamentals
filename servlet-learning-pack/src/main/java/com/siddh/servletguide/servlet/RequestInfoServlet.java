package com.siddh.servletguide.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/request-info/*")
public class RequestInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");

        resp.getWriter().println("Method: " + req.getMethod());
        resp.getWriter().println("URI: " + req.getRequestURI());
        resp.getWriter().println("PathInfo: " + req.getPathInfo());
        resp.getWriter().println("QueryString: " + req.getQueryString());
        resp.getWriter().println("RemoteAddr: " + req.getRemoteAddr());
        resp.getWriter().println();

        resp.getWriter().println("Parameters:");
        for (Enumeration<String> e = req.getParameterNames(); e.hasMoreElements(); ) {
            String name = e.nextElement();
            resp.getWriter().println("  " + name + " = " + req.getParameter(name));
        }

        resp.getWriter().println();
        resp.getWriter().println("Headers:");
        for (Enumeration<String> e = req.getHeaderNames(); e.hasMoreElements(); ) {
            String name = e.nextElement();
            resp.getWriter().println("  " + name + " = " + req.getHeader(name));
        }
    }
}
