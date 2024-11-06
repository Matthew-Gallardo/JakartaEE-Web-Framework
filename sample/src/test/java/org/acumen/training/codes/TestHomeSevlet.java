package org.acumen.training.codes;

import static org.junit.Assert.assertTrue;

import static org.mockito.BDDMockito.given;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@ExtendWith(MockitoExtension.class)
public class TestHomeSevlet {
	
	@Mock
	private HttpServletRequest req;
	
	@Mock
	private HttpServletResponse resp;

	
	@Test
	public void testServiceGet() throws ServletException, IOException {
		//G
		given(req.getMethod()).willReturn("GET");
		StringWriter writer = new StringWriter();
		PrintWriter out= new PrintWriter(writer);
		given(resp.getWriter()).willReturn(out);
		//W
		HomeServlet servlet= new  HomeServlet();
		servlet.init();
		servlet.service(req, resp);
		servlet.destroy();
		//Then
		out.flush();
		assertTrue(writer.toString().contains("I am GET!"));
		
		
	}
	@Test
	public void testServicePost() throws ServletException, IOException {
		//G
		given(req.getMethod()).willReturn("POST");
		StringWriter writer = new StringWriter();
		PrintWriter out= new PrintWriter(writer);
		given(resp.getWriter()).willReturn(out);
		//W
		HomeServlet servlet= new  HomeServlet();
		servlet.init();
		servlet.service(req, resp);
		servlet.destroy();
		//Then
		out.flush();
		assertTrue(writer.toString().contains("I am POST!"));
		
		
	}
}
