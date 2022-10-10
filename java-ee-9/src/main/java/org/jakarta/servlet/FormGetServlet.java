package org.jakarta.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get")
public class FormGetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        String amount = req.getParameter("amount");

        writer.print("<!DOCTYPE html>");
        writer.print("<head>");
        writer.print("<title>Aula retardada</title>");
        writer.print("</head>");
        writer.print("<body>");
        writer.print("<h3>" + amount + "</h3>");
        writer.print("</body>");
        writer.print("</html>");

        writer.close();
    }
}
