package org.acumen.training.codes;

import java.io.IOException;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = "/book/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());

   

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
        LOGGER.info("Login attempt made by user.");
        resp.sendRedirect("gallardoweb3/book/menu"); 
    }
}
