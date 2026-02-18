package com.siddh.servletguide.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleAuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        filterConfig.getServletContext().log("SimpleAuthFilter initialized.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpResp = (HttpServletResponse) response;

        String auth = httpReq.getParameter("auth");
        if (!"letmein".equals(auth)) {
            httpResp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResp.setContentType("text/plain");
            httpResp.getWriter().println("Unauthorized. Use /config?auth=letmein");
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
