package org.acumen.training.codes;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		HttpSession sess = req.getSession(true);
		
		String username="root";
		String password="admin2255";
		
		sess.setAttribute("username", username);
		sess.setAttribute("password", password);
		String newUrl = resp.encodeRedirectURL("/gallardoweb1/jsp/profile_form.html"); // URL Rewriting
		resp.sendRedirect(newUrl);
	}

}
