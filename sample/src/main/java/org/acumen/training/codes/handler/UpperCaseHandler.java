package org.acumen.training.codes.handler;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "UpperCaseHandler", urlPatterns = "/profile/upper")
public class UpperCaseHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String fname = (String) req.getAttribute("firstname");
			String lname = (String) req.getAttribute("lastname");
			
			//updating attribute
			req.setAttribute("firstname", fname.toUpperCase());
			req.setAttribute("lastname", lname.toUpperCase());
			
			//Addition of attribute
			req.setAttribute("modified by", "UpperCaseHandler");
			
			//Removal
			req.removeAttribute("salary");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/profile_result.jsp");
			dispatcher.forward(req, resp);
		}

}
