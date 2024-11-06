package org.acumen.training.codes.filter;
 
import java.io.IOException;
 
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
 
public class WelcomeFilter implements Filter {
 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//MANIPULATION NG REQUEST or PAPASOK
		request.setAttribute("tokenId", "12345");
 
		// IMPLEMENTATION NG MANIPULATIONS
		chain.doFilter(request, response);
 
		// MANIPULATION SA RESPONSE OR PALABAS
		response.setContentType("application/msword");
		HttpServletResponse res = (HttpServletResponse) response;
		res.setHeader("Content-Disposition", "attachment; filename=welcome.doc");
 
	}
 
}
 