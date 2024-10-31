package org.acumen.training.codes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.InputMismatchException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//Controller
@WebServlet(name = "ProfileServlet", urlPatterns = "/profile/request.html", 
            loadOnStartup = 4)
          //  initParams = {@WebInitParam(name="company", value = "SBC"),
            //			  @WebInitParam(name="manager", value = "Sir Bene")})

public class ProfileServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private String company;
	private String manager;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	   company = config.getInitParameter("company");
	   manager = config.getInitParameter("manager");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		if (method.equalsIgnoreCase("GET")) {
			doGet(req, resp);
		} else if (method.equalsIgnoreCase("POST")) {
			doPost(req, resp);
		}
	}
	

    // Post transaction
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	Map<String, String[]> params = req.getParameterMap();
    	//Request attributes
    	//Validations for both strings and numeric data
    	Integer id;
    	String firstname;
    	String lastname;
    	Double salary;
    	
    	try {
        	 id = Integer.parseInt(req.getParameter("id")) ;
        	 firstname = req.getParameter("firstname");
        	 lastname = req.getParameter("lastname");
        	 salary =Double.parseDouble(req.getParameter("salary")) ;
		} catch (NumberFormatException e) {
			id=0;
			firstname = req.getParameter("firstname");
			lastname = req.getParameter("lastname");
			salary=0.0;
			
			e.printStackTrace();
			throw new InputMismatchException("Data cannot be converted");
		}
    	req.setAttribute("id", id);
    	req.setAttribute("firstname", firstname);
    	req.setAttribute("lastname", lastname);
    	req.setAttribute("salary", salary);
    	
    	RequestDispatcher dispatcher = req.getRequestDispatcher("/profile/upper");
    	dispatcher.forward(req, resp);
    }
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//respond to hyperlink
    	String qs = req.getQueryString();
    	String[] values = qs.split("&");
    	req.setAttribute("values", values);
    	RequestDispatcher dispatcher = req.getRequestDispatcher("/profile/params");
    	dispatcher.forward(req, resp);
    }
    
 
	

}
