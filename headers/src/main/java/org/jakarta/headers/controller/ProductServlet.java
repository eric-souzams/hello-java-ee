package org.jakarta.headers.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import jakarta.jws.WebService;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.HttpMethod;
import org.jakarta.headers.models.Product;
import org.jakarta.headers.services.ProductService;
import org.jakarta.headers.services.ProductServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/products")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        List<Product> list = productService.list();
        ObjectMapper mapper = new ObjectMapper();
        String response = mapper.writeValueAsString(list);

        resp.setContentType("application/json");
        resp.getWriter().write(response);

        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        Product product = objectMapper.readValue(inputStream, Product.class);
        resp.setContentType("text/html;charset=UTF-8");

        try (PrintWriter writer = resp.getWriter()) {
            writer.print("<!DOCTYPE html>");
            writer.print("<html>");
            writer.print("<head>");
            writer.print("<title>Products</title>");
            writer.print("</head>");
            writer.print("<body>");
            writer.print("<h3>Product</h3>");
            writer.print("<ul>");
            writer.print("<li>Id: " + product.getId() +"</li>");
            writer.print("<li>Name: " + product.getName() + "</li>");
            writer.print("<li>Type: " + product.getType() + "</li>");
            writer.print("<li>Price: " + product.getPrice() + "</li>");
            writer.print("</ul>");
            writer.print("</body>");
            writer.print("</html>");
        }
    }

}
