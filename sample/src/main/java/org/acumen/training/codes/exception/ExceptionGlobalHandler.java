package org.acumen.training.codes.exception;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ExceptionGlobalHandler", urlPatterns = "/exception/global/handler")
public class ExceptionGlobalHandler extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Throwable throwable = (Throwable) req.getAttribute("jakarta.servlet.error.exception");
		String servletName = (String) req.getAttribute("jakarta.servlet.error.servlet_name");
		Integer statusCode = (Integer) req.getAttribute("jakarta.servlet.error.status_code");
		String uri = (String) req.getAttribute("jakarta.servlet.error.request_uri");

		// Logger
		req.setAttribute("exception_type", throwable.getClass().getName());
		req.setAttribute("exception_msg", throwable.getMessage());
		req.setAttribute("servlet_name", servletName);
		req.setAttribute("status_code", statusCode);
		req.setAttribute("uri", uri);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/error/global_error.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Throwable throwable = (Throwable) req.getAttribute("jakarta.servlet.error.exception");
		String servletName = (String) req.getAttribute("jakarta.servlet.error.servlet_name");
		Integer statusCode = (Integer) req.getAttribute("jakarta.servlet.error.status_code");
		String uri = (String) req.getAttribute("jakarta.servlet.error.request_uri");

		// Logger
		req.setAttribute("exception_type", throwable.getClass().getName());
		req.setAttribute("exception_msg", throwable.getMessage());
		req.setAttribute("servlet_name", servletName);
		req.setAttribute("status_code", statusCode);
		req.setAttribute("uri", uri);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/error/global_error.jsp");
		dispatcher.forward(req, resp);
	}

}
