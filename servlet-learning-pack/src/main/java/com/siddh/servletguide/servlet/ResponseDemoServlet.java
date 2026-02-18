package com.siddh.servletguide.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/response-demo")
public class ResponseDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setHeader("X-App", "ServletLearningPack");
        resp.setContentType("application/json");
        resp.getWriter().println("{\"status\":\"ok\",\"message\":\"Response created by servlet\"}");
    }
}
