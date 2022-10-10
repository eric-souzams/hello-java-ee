package org.jakarta.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(value = "/register")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> errors = new HashMap<>();
        PrintWriter writer = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String pais = req.getParameter("pais");
        String[] languages = req.getParameterValues("languages");
        String[] roles = req.getParameterValues("roles");
        String idioms = req.getParameter("idioms");
        String secret = req.getParameter("secret");
        String active = req.getParameter("active");

        if (username == null || username.isBlank()) errors.put("username", "Username is required.");
        if (password == null || password.isBlank()) errors.put("password", "Password can't be empty..");
        if (email == null || email.isBlank() || !email.contains("@")) errors.put("email", "Email invalid.");
        if (pais == null || pais.equals("") || pais.equals(" ")) errors.put("pais", "Pais is required.");
        if (languages == null || languages.length == 0) errors.put("languages", "You must select at least one language.");
        if (roles == null || roles.length == 0) errors.put("roles", "You must select at least one role.");
        if (idioms == null) errors.put("idioms", "Idioms is required.");


        if (errors.isEmpty()) {
            writer.print("<!DOCTYPE html>");
            writer.print("<html>");
            writer.print("<head>");
            writer.print("<title>Form Register</title>");
            writer.print("</head>");
            writer.print("<body>");
            writer.print("<h3>Data from Register</h3>");
            writer.print("<ul>");
            writer.print("<li>Username: " + username + "</li>");
            writer.print("<li>Email: " + email + "</li>");
            writer.print("<li>Password: " + password + "</li>");
            writer.print("<li>Pais: " + pais + "</li>");

            writer.print("<li> Languages:");
            writer.print("<ul>");
            Arrays.asList(languages).forEach(language -> writer.print("<li>" + language + "</li>"));
            writer.print("</ul>");
            writer.print("</li>");

            writer.print("<li>Roles: ");
            writer.print("<ul>");
            Arrays.asList(roles).forEach(role -> writer.print("<li>" + role + "</li>"));
            writer.print("</ul>");
            writer.print("</li>");

            writer.print("<li>Idioms: " + idioms + "</li>");
            writer.print("<li>Secret: " + secret + "</li>");
            writer.print("<li>Active: " + active + "</li>");

            writer.print("</ul>");
            writer.print("</body>");
            writer.print("</html>");
        } else {
            req.setAttribute("errors", errors);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }

    }
}
