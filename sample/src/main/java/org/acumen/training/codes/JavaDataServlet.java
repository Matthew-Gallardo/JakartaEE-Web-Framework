package org.acumen.training.codes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class JavaDataServlet extends HttpServlet{
	private static final Logger LOGGER = Logger.getLogger(JavaDataServlet.class.getName());
	private static final long serialVersionUID = 1L;
	private String dbUser;
	private String dbPass;
	private String dbUrl;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		 //dbUser = config.getInitParameter("dbUser");
		 //dbPass = config.getInitParameter("dbPass");
		// dbUrl = config.getInitParameter("dbUrl");
		ServletContext context = config.getServletContext();
		String company = context.getInitParameter("company");
		String manager = context.getInitParameter("manager");
		LOGGER.info("%s %s ".formatted(company, manager));
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ServletContext context = req.getServletContext();
		dbUser = context.getServletRegistration("JavaDataServlet").getInitParameter("dbUser");
	    dbPass = context.getServletRegistration("JavaDataServlet").getInitParameter("dbPass");
	    dbUrl = context.getServletRegistration("JavaDataServlet").getInitParameter("dbUrl");
	    LOGGER.info("Db Connect thru : %s %s %s".formatted(dbUser, dbPass, dbUrl));
		 //LOGGER.info("%s %s %s".formatted(dbUser, dbPass, dbUrl));

			String company = context.getInitParameter("company");
			String manager = context.getInitParameter("manager");
			PrintWriter out= resp.getWriter();
		    out.println(company);
		    out.println(manager);
	
	}
	@Override
	public void destroy() {
		dbUser=null;
		dbPass=null;
		dbUrl = null;
	}

}
