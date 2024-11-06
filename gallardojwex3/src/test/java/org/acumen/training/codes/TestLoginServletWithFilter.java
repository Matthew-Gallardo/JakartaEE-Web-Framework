package org.acumen.training.codes;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.acumen.training.codes.dao.UserDao;
import org.acumen.training.codes.filter.AuthenticationFilter;
import org.acumen.training.codes.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@ExtendWith(MockitoExtension.class)
public class TestLoginServletWithFilter {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private FilterChain filterChain;

    @Mock
    private UserDao userDao;

    @Mock
    private User user;

    @Test
    public void testAuthenticationFilterValidUser() throws ServletException, IOException {
        // Given
        String email = "user@example.com";
        String password = "password123";
        
        given(request.getParameter("email")).willReturn(email);
        given(request.getParameter("password")).willReturn(password);
        
        
        given(userDao.findUserByCredentials(email, password)).willReturn(user);
        given(user.getFirstName()).willReturn("John");
        
        
        given(request.getSession(true)).willReturn(session);
        
        AuthenticationFilter filter = new AuthenticationFilter();
        filter.init(null);  
        
       
        filter.doFilter(request, response, filterChain);

        verify(response).sendRedirect("/gallardoweb3/book");
    }

    @Test
    public void testAuthenticationFilterInvalidUser() throws ServletException, IOException {
        // Given
        String email = "user@example.com";
        String password = "wrongPassword";
        
        given(request.getParameter("email")).willReturn(email);
        given(request.getParameter("password")).willReturn(password);
        
        AuthenticationFilter filter = new AuthenticationFilter();
        filter.init(null);  // Initialize the filter
        
        // When the filter is applied
        filter.doFilter(request, response, filterChain);

        
        verify(response).sendRedirect("/gallardoweb3/error/book/wrong_password.jsp");
    }

    @Test
    public void testAuthenticationFilterMissingCredentials() throws ServletException, IOException {
        // Given missing email and password parameters
        given(request.getParameter("email")).willReturn(null);
        given(request.getParameter("password")).willReturn(null);
        
        AuthenticationFilter filter = new AuthenticationFilter();
        filter.init(null);  // Initialize the filter
        
        // When the filter is applied
        filter.doFilter(request, response, filterChain);

        // Then verify that the filter redirects to the login form
        verify(response).sendRedirect("/gallardoweb3/book/login_form");
    }
}
