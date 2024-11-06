package org.acumen.training.codes.filter;

import java.io.IOException;
import java.util.logging.Logger;

import org.acumen.training.codes.dao.UserDao;
import org.acumen.training.codes.model.User;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = "/book/login")
public class AuthenticationFilter extends HttpFilter implements Filter {
	private static final Logger LOGGER = Logger.getLogger(AuthenticationFilter.class.getName());
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		userDao = new UserDao("bookstore_pu");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		LOGGER.info("Validation Filter Start");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		if (email != null && password != null) {
			User user = userDao.findUserByCredentials(email.trim(), password.trim());
			if (user != null) {
				HttpSession session = req.getSession(true);
				session.setAttribute("username", user.getFirstName());
				String newUrl = resp.encodeRedirectURL("/gallardoweb3/book");
				LOGGER.info("Successfully logged-in, validated");
				resp.sendRedirect(newUrl);
				return;
			} else {
				resp.sendRedirect("/gallardoweb3/error/book/wrong_password.jsp");
				LOGGER.info("Wrong Password by user");
			}
		} else {
			resp.sendRedirect("/gallardoweb3/book/login_form");
			LOGGER.info("Redirection to Login Page");
		}

	}

	@Override
	public void destroy() {
		userDao = null;
	}
}
