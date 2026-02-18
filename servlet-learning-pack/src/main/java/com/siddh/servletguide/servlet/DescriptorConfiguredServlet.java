package com.siddh.servletguide.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DescriptorConfiguredServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String owner = config.getInitParameter("owner");
        Object fromNavigation = req.getAttribute("fromNavigation");

        resp.setContentType("text/plain");
        resp.getWriter().println("This servlet is configured via web.xml.");
        resp.getWriter().println("owner init-param=" + owner);
        resp.getWriter().println("request attribute fromNavigation=" + fromNavigation);
    }
}
