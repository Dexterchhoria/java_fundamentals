package com.siddh.servletguide.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/async-demo", asyncSupported = true)
public class AsyncDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final AsyncContext asyncContext = req.startAsync();
        asyncContext.setTimeout(5000);

        asyncContext.start(() -> {
            try {
                Thread.sleep(1500);
                HttpServletResponse asyncResp = (HttpServletResponse) asyncContext.getResponse();
                asyncResp.setContentType("text/plain");
                asyncResp.getWriter().println("Async work completed after 1.5 seconds.");
            } catch (Exception e) {
                getServletContext().log("Async error", e);
            } finally {
                asyncContext.complete();
            }
        });
    }
}
