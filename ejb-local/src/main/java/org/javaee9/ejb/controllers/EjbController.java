package org.javaee9.ejb.controllers;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.javaee9.ejb.models.Product;
import org.javaee9.ejb.services.EjbService;
import org.javaee9.ejb.services.EjbServiceLocal;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet("/index")
public class EjbController extends HttpServlet {

//    @Inject
//    private EjbService ejbService;
//
//    @Inject
//    private EjbServiceLocal ejbService2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EjbServiceLocal ejbService = null;
        EjbServiceLocal ejbService2 = null;

        try {
            InitialContext initialContext = new InitialContext();
            ejbService = (EjbServiceLocal) initialContext.lookup("java:global/ejb/EjbService!org.javaee9.ejb.services.EjbServiceLocal");
            ejbService2 = (EjbServiceLocal) initialContext.lookup("java:global/ejb/EjbService!org.javaee9.ejb.services.EjbServiceLocal");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        Product cow = ejbService.save(new Product("Cow"));
        System.out.println("new: " + cow);
        System.out.println("equal: " + ejbService.equals(ejbService2));


        req.setAttribute("lists", ejbService.list());
        req.setAttribute("message", ejbService.test());
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
