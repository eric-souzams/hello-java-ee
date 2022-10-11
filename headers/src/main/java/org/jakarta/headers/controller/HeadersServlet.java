package org.jakarta.headers.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(value = "/headers")
public class HeadersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String method = req.getMethod();
        String requestUri = req.getRequestURI();
        String requestUrl = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String ip = req.getLocalAddr();
        String ipClient = req.getRemoteAddr();
        int localPort = req.getLocalPort();
        String scheme = req.getScheme();
        String host = req.getHeader("host");
        Enumeration<String> headers = req.getHeaderNames();
        String url = scheme + "://" + host + contextPath + servletPath;
        String url2 = scheme + "://" + ip + ":" + localPort + contextPath + servletPath;

        try (PrintWriter writer = resp.getWriter()) {
            writer.print("<!DOCTYPE html>");
            writer.print("<html>");
            writer.print("<head>");
            writer.print("<title>Form Register</title>");
            writer.print("</head>");
            writer.print("<body>");
            writer.print("<h3>Data from Register</h3>");
            writer.print("<ul>");
            writer.print("<li>method: " + method + "</li>");
            writer.print("<li>request uri: " + requestUri + "</li>");
            writer.print("<li>request url: " + requestUrl + "</li>");
            writer.print("<li>context path: " + contextPath + "</li>");
            writer.print("<li>servlet path: " + servletPath + "</li>");
            writer.print("<li>id local: " + ip + "</li>");
            writer.print("<li>id client: " + ipClient + "</li>");
            writer.print("<li>port: " + localPort + "</li>");
            writer.print("<li>scheme: " + scheme + "</li>");
            writer.print("<li>host: " + host + "</li>");
            writer.print("<li>url 1: " + url + "</li>");
            writer.print("<li>url 2: " + url2 + "</li>");
            writer.print("<li>headers: " + "</li>");

            while (headers.hasMoreElements()) {
                String element = headers.nextElement();
                writer.print("<li>- " + element + ": " + req.getHeader(element) + "</li>");
            }

            writer.print("</ul>");
            writer.print("</body>");
            writer.print("</html>");
        }
    }
}
