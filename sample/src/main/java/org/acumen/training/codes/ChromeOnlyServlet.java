package org.acumen.training.codes;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ChromeOnlyServlet", urlPatterns = "/restrict/chrome/page")
public class ChromeOnlyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    PrintWriter out = resp.getWriter();
	    String userAgent = req.getHeader("user-agent");

	    
	    if (userAgent != null && userAgent.contains("Chrome") && !userAgent.contains("Edg")) {
	        out.write("Browser supported: Chrome Only");
	    } else {
	        resp.sendError(HttpServletResponse.SC_FORBIDDEN, "Only Chrome is supported.");
	    }
	    
	}


}
