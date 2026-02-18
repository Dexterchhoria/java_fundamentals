package com.siddh.servletguide.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/upload")
@MultipartConfig(maxFileSize = 5 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
public class UploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<!DOCTYPE html><html><body>");
        resp.getWriter().println("<h2>Upload Demo</h2>");
        resp.getWriter().println("<form method='post' enctype='multipart/form-data'>");
        resp.getWriter().println("<input type='file' name='file' />");
        resp.getWriter().println("<button type='submit'>Upload</button>");
        resp.getWriter().println("</form>");
        resp.getWriter().println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part filePart = req.getPart("file");
        String fileName = filePart == null ? null : filePart.getSubmittedFileName();
        long size = filePart == null ? 0 : filePart.getSize();

        resp.setContentType("text/plain");
        resp.getWriter().println("Upload processed in servlet.");
        resp.getWriter().println("filename=" + fileName);
        resp.getWriter().println("size(bytes)=" + size);
    }
}
