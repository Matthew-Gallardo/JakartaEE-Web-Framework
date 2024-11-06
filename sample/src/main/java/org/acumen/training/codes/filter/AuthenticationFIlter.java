package org.acumen.training.codes.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(filterName = "AuthenticationFIlter", urlPatterns = "/jsp/project_form.html")
public class AuthenticationFIlter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		//CHECK username if nasa database
		//redirect to error page
		String username= req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("%s %s".formatted(username,password));
		
		chain.doFilter(request, response);
		HttpServletResponse resp = (HttpServletResponse)response;
	}

}
