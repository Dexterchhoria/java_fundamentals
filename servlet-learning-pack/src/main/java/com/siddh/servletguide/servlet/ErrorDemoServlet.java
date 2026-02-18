package com.siddh.servletguide.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/error-demo")
public class ErrorDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        if ("404".equals(type)) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Generated 404 for demo.");
            return;
        }
        if ("500".equals(type)) {
            throw new RuntimeException("Generated runtime exception for demo.");
        }

        resp.setContentType("text/plain");
        resp.getWriter().println("Pass ?type=404 or ?type=500 to test error handling.");
    }
}
