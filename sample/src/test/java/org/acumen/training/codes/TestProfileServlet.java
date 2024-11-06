package org.acumen.training.codes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import static org.mockito.Mockito.atLeast;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@ExtendWith(MockitoExtension.class)
public class TestProfileServlet {
	@Mock
	private HttpServletRequest request;
	@Mock
	private HttpServletResponse response;
	@Mock
	private RequestDispatcher dispatcher;
	@Mock
	private ServletConfig config;
	@Mock
	private HttpSession session;

	
	@Test
	public void testProfileServletGet() throws ServletException, IOException {
		//G
		given(request.getQueryString()).willReturn("id=1003&firstname=Maria&lastname=Clara");
		given(request.getRequestDispatcher("/profile/params")).willReturn(dispatcher);
		given(config.getInitParameter("manager")).willReturn("Sir Bene");
		given(config.getInitParameter("company")).willReturn("SBC");
		//W
		ProfileServlet servlet = new ProfileServlet();
		servlet.init(config);
		servlet.doGet(request,response);
		//T
		verify(request,atLeast(1)).getQueryString();
		verify(request,atLeast(1)).getRequestDispatcher("/profile/params");
	
	}
	
	@Test
	public void testProfileServletPOST() throws ServletException, IOException {
		//G
		given(request.getSession()).willReturn(session);
		given(session.getAttribute("username")).willReturn("root");
		given(session.getAttribute("password")).willReturn("admin2255");
		
		given(request.getRequestDispatcher("/profile/upper")).willReturn(dispatcher);
		given(config.getInitParameter("manager")).willReturn("Sir Bene");
		given(config.getInitParameter("company")).willReturn("SBC");
		//W
		given(request.getParameter("id")).willReturn("101");
		given(request.getParameter("firstname")).willReturn("Lebron");
		given(request.getParameter("lastname")).willReturn("James");
		given(request.getParameter("salary")).willReturn("50000.00");
		
		//T
		ProfileServlet servlet = new ProfileServlet();
		servlet.init(config);
		servlet.doPost(request,response);
		
		verify(request).getParameter("id");
		verify(request).getParameter("firstname");
		verify(request).getParameter("lastname");
		verify(request).getParameter("salary");
		
		
	}

}
