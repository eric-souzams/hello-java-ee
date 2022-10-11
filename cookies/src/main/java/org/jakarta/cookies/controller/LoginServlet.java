package org.jakarta.cookies.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("admin") && password.equals("123")) {
            Cookie user = new Cookie("username_cookie", username);
            resp.addCookie(user);

            resp.setContentType("text/html");

            PrintWriter printWriter = resp.getWriter();
            printWriter.write("Success.");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Without permission.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Optional<String> cookie = Arrays.stream(cookies).filter(c -> "username".equals(c.getName())).map(Cookie::getValue).findAny();

        if (cookie.isPresent()) {
            Cookie cookie1 = new Cookie("username", "");
            cookie1.setMaxAge(0);
            resp.addCookie(cookie1);
        }

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
