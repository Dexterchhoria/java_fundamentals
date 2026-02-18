package com.siddh.servletguide.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/navigation")
public class NavigationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = req.getParameter("mode");

        if ("redirect".equalsIgnoreCase(mode)) {
            resp.sendRedirect(req.getContextPath() + "/hello");
            return;
        }

        if ("forward".equalsIgnoreCase(mode)) {
            req.setAttribute("fromNavigation", "This came via RequestDispatcher.forward");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/descriptor");
            dispatcher.forward(req, resp);
            return;
        }

        if ("include".equalsIgnoreCase(mode)) {
            resp.setContentType("text/plain");
            resp.getWriter().println("Before include");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/hello");
            dispatcher.include(req, resp);
            resp.getWriter().println("After include");
            return;
        }

        resp.setContentType("text/plain");
        resp.getWriter().println("Navigation demo");
        resp.getWriter().println("Use one of:");
        resp.getWriter().println("  ?mode=redirect");
        resp.getWriter().println("  ?mode=forward");
        resp.getWriter().println("  ?mode=include");
    }
}
