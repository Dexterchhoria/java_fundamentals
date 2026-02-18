package com.siddh.servletguide.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestLoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        filterConfig.getServletContext().log("RequestLoggingFilter initialized.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        long durationMs = System.currentTimeMillis() - start;
        request.getServletContext().log(httpReq.getMethod() + " " + httpReq.getRequestURI() + " took " + durationMs + " ms");
    }

    @Override
    public void destroy() {
    }
}
