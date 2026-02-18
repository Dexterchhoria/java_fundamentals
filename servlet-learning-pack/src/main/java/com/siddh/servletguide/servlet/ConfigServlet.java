package com.siddh.servletguide.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = "/config",
        initParams = {
                @WebInitParam(name = "team", value = "backend"),
                @WebInitParam(name = "module", value = "servlet-guide")
        }
)
public class ConfigServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        ServletContext context = getServletContext();

        resp.setContentType("text/plain");
        resp.getWriter().println("ServletConfig params:");
        resp.getWriter().println("team=" + config.getInitParameter("team"));
        resp.getWriter().println("module=" + config.getInitParameter("module"));
        resp.getWriter().println();

        resp.getWriter().println("ServletContext params (from web.xml):");
        resp.getWriter().println("appName=" + context.getInitParameter("appName"));
        resp.getWriter().println("supportEmail=" + context.getInitParameter("supportEmail"));
        resp.getWriter().println();

        Object startupTime = context.getAttribute("startupTime");
        resp.getWriter().println("Context attribute startupTime=" + startupTime);
    }
}
