package org.acumen.training.codes;

import java.io.IOException;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SignupServlet", urlPatterns = "/book/signup")
public class SignupServlet  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(SignupServlet.class.getName());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/book/signup_form.jsp").forward(req, resp);
		
	}
	
	
	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      
	        String firstName = req.getParameter("first_name").trim();
	        String lastName = req.getParameter("last_name").trim();
	        String email = req.getParameter("email").trim();
	        String password = req.getParameter("password").trim();
	        String confirmPassword = req.getParameter("confirmPassword").trim();

	        
	        req.setAttribute("first_name", firstName);
	        req.setAttribute("last_name", lastName);
	        req.setAttribute("email", email);
	        req.setAttribute("password", password);
	        req.setAttribute("confirmPassword", confirmPassword);

	        req.getRequestDispatcher("/book/signupValidation").forward(req, resp);
	        LOGGER.info("Forwarding to validation handler");
	    }
		

}
