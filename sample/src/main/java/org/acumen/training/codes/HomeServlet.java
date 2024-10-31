package org.acumen.training.codes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HomeServlet", urlPatterns = "/home", loadOnStartup = 3)
public class HomeServlet extends HttpServlet{
	private static final Logger LOGGER = Logger.getLogger(HomeServlet.class.getName());
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		LOGGER.info("Run HomeServlet");
		PrintWriter out = resp.getWriter();
		String method = req.getMethod();
		if (method.equalsIgnoreCase("GET")) {
			out.write("I am GET!");
		} else if (method.equalsIgnoreCase("POST")) {
			out.write("I am POST!");
		}
		LOGGER.info("Stop HomeServlet");
	}
	
	@Override
	public void destroy() {
		LOGGER.info("Garbage collect HomeServlet");
	}

}
