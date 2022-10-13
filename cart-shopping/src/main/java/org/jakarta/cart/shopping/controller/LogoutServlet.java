package org.jakarta.cart.shopping.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.jakarta.cart.shopping.services.LoginService;
import org.jakarta.cart.shopping.services.LoginServiceImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService loginService = new LoginServiceImpl();
        Optional<String> username = loginService.getUsername(req);
        if (username.isPresent()) {
            HttpSession session = req.getSession();
            session.invalidate();
        }

        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }

}
