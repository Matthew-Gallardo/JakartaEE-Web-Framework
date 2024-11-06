package org.acumen.training.codes;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@ExtendWith(MockitoExtension.class)
public class TestSignupServlet {

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private RequestDispatcher dispatcher;

    @Test
    public void testSignupServletGet() throws ServletException, IOException {
        // Given
        given(request.getRequestDispatcher("/WEB-INF/jsp/book/signup_form.jsp")).willReturn(dispatcher);
        
        // When
        SignupServlet servlet = new SignupServlet();
        servlet.doGet(request, response);
        
        // Then
        verify(request).getRequestDispatcher("/WEB-INF/jsp/book/signup_form.jsp");
        verify(dispatcher).forward(request, response);  
    }

    @Test
    public void testSignupServletPost() throws ServletException, IOException {
        // Given
        given(request.getParameter("first_name")).willReturn("Lebron");
        given(request.getParameter("last_name")).willReturn("James");
        given(request.getParameter("email")).willReturn("james.lebron23@example.com");
        given(request.getParameter("password")).willReturn("password123");
        given(request.getParameter("confirmPassword")).willReturn("password123");
        given(request.getRequestDispatcher("/book/signupValidation")).willReturn(dispatcher);
        
        // When
        SignupServlet servlet = new SignupServlet();
        servlet.doPost(request, response);
        
        // Then
        verify(request).getParameter("first_name");
        verify(request).getParameter("last_name");
        verify(request).getParameter("email");
        verify(request).getParameter("password");
        verify(request).getParameter("confirmPassword");

        verify(request).setAttribute("first_name", "Lebron");
        verify(request).setAttribute("last_name", "James");
        verify(request).setAttribute("email", "james.lebron23@example.com");
        verify(request).setAttribute("password", "password123");
        verify(request).setAttribute("confirmPassword", "password123");

        verify(request).getRequestDispatcher("/book/signupValidation");
        verify(dispatcher).forward(request, response);  
    }
}
