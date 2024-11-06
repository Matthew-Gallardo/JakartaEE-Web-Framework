package org.acumen.training.codes;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "LogoutServlet", urlPatterns = "/book/logout")
public class LogoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(LogoutServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
            LOGGER.info("Session Invalidated");
        }

       
        resp.sendRedirect("/gallardoweb3/book/login_form");
    }
}
