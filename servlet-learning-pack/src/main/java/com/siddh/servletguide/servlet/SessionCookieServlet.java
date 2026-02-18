package com.siddh.servletguide.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session-cookie")
public class SessionCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer visits = (Integer) session.getAttribute("visits");
        if (visits == null) {
            visits = 0;
        }
        visits++;
        session.setAttribute("visits", visits);

        Cookie themeCookie = new Cookie("theme", "light");
        themeCookie.setMaxAge(24 * 60 * 60);
        themeCookie.setHttpOnly(true);
        themeCookie.setPath(req.getContextPath().isEmpty() ? "/" : req.getContextPath());
        resp.addCookie(themeCookie);

        resp.setContentType("text/plain");
        resp.getWriter().println("Session id: " + session.getId());
        resp.getWriter().println("Visit count in this session: " + visits);
        resp.getWriter().println("A cookie named 'theme' was set.");
    }
}
