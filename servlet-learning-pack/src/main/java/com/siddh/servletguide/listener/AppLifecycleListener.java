package com.siddh.servletguide.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.time.Instant;

public class AppLifecycleListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("startupTime", Instant.now().toString());
        sce.getServletContext().log("Application started.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().log("Application stopping.");
    }
}
