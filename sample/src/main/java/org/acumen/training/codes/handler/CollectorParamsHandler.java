package org.acumen.training.codes.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name = "CollectorParamsHandler", urlPatterns = "/profile/params")
public class CollectorParamsHandler  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] values = (String[]) req.getAttribute("values");
		List<String[]>params = new ArrayList<>();
			for (String p : values) {
				String[] pairStrings  = p.split("=");
				params.add(pairStrings);
				
			}
			System.out.println(params);
			req.removeAttribute("values");
			req.setAttribute("params", params);		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/profile_params.jsp");
    	dispatcher.forward(req, resp);
	}
	

}
