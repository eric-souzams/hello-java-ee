package org.jakarta.cart.shopping.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.jakarta.cart.shopping.models.Cart;
import org.jakarta.cart.shopping.models.CartItem;
import org.jakarta.cart.shopping.models.Product;
import org.jakarta.cart.shopping.services.ProductService;
import org.jakarta.cart.shopping.services.ProductServiceImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        ProductService productService = new ProductServiceImpl();
        Optional<Product> product = productService.findById(id);

        if (product.isPresent()) {
            CartItem cartItem = new CartItem(1, product.get());
            HttpSession session = req.getSession();

            Cart cart;
            if (session.getAttribute("cart") == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            } else {
                cart = (Cart) session.getAttribute("cart");
            }

            cart.addItem(cartItem);
        }

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
