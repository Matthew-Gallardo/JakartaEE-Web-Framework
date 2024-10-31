package org.acumen.training.codes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello.html", loadOnStartup = 2)
public class HelloWorldServlet extends GenericServlet{
	private static final Logger LOGGER = Logger.getLogger(HelloWorldServlet.class.getName());
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		LOGGER.info("Start of the servlet...");
	}

	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
		// Page Generation process
		LOGGER.info("Run HelloWorldServlet...");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.write("<h1>Hello Philippines</h1>");
		out.write("<p>We are the SBC developers....</p>");
		LOGGER.info("Stop HelloWorldServlet...");
	}
	
	@Override
	public void destroy() {
		LOGGER.info("HelloWorldServlet garbage collected...");
	}

}
