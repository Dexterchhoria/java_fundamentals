package com.siddh.servletguide.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(urlPatterns = "/lifecycle", loadOnStartup = 2)
public class LifecycleServlet extends HttpServlet {
    private final AtomicInteger requestCount = new AtomicInteger(0);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        getServletContext().log("LifecycleServlet init() called.");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        requestCount.incrementAndGet();
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("Lifecycle servlet");
        resp.getWriter().println("Requests served by this instance: " + requestCount.get());
    }

    @Override
    public void destroy() {
        getServletContext().log("LifecycleServlet destroy() called.");
    }
}
