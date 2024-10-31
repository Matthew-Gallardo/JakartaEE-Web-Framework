package org.acumen.training.codes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ProfileServlet", urlPatterns = "/profile/request.html", 
            loadOnStartup = 4)
public class ProfileServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		if (method.equalsIgnoreCase("GET")) {
			doGet(req, resp);
		} else if (method.equalsIgnoreCase("POST")) {
			doPost(req, resp);
		}
	}
	
	// Get transaction
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	renderPages(req, resp);
    }
    
    // Post transaction
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	renderPages(req, resp);
    }
    
    public void renderPages(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException  {
    	resp.setContentType("text/html");
    	PrintWriter out = resp.getWriter();
    	// Query String
    	/*
    	String id = req.getParameter("id");
    	String fname = req.getParameter("firstname");
    	String lname = req.getParameter("lastname");
    	String salary = req.getParameter("salary");
    	
    	*/
    	/*
    	Map<String, String[]> params = req.getParameterMap();
    	
    	out.write("<table>");
    	out.write("<tr>");
    	out.write("<td>%s</td>".formatted(params.get("id")[0]));
    	out.write("<td>%s</td>".formatted(params.get("firstname")[0]));
    	out.write("<td>%s</td>".formatted(params.get("lastname")[0]));
    	out.write("<td>%s</td>".formatted(params.get("salary")[0]));
    	out.write("<td>%s</td>".formatted(req.getQueryString()));
    	out.write("</tr>");
    	out.write("</table>");
    	
    	out.write("<ol>");
    	out.write("<li>%s</li>".formatted(params.get("color")[0]));
    	out.write("<li>%s</li>".formatted(params.get("comment")[0]));
    	out.write("<li>%s</li>".formatted(params.get("token")[0]));
    	for (String f : params.get("food")) {
    		out.write("<li>%s</li>".formatted(f));
    	}
    	out.write("</ol>");
    	
    	*/
    	out.write("<ol>");
    	Enumeration<String> paramNames = req.getParameterNames();
    	while(paramNames.hasMoreElements()) {
    		String name = paramNames.nextElement();
    		String[] paramValues = req.getParameterValues(name);
    		for (String p : paramValues) {
        		out.write("<li>%s</li>".formatted(p));
        	}
    	}
    	out.write("</ol>");
    		
    }
    
  
	

}
