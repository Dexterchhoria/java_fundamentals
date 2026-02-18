package com.siddh.servletguide.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

public class UserSessionListener implements HttpSessionListener {
    private static final AtomicInteger ACTIVE_SESSIONS = new AtomicInteger(0);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        int count = ACTIVE_SESSIONS.incrementAndGet();
        se.getSession().getServletContext().log("Session created: " + se.getSession().getId() + ", activeSessions=" + count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        int count = ACTIVE_SESSIONS.decrementAndGet();
        se.getSession().getServletContext().log("Session destroyed: " + se.getSession().getId() + ", activeSessions=" + count);
    }
}
