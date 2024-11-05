package org.acumen.training.codes;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "XLSGenerationServlet", urlPatterns = "/content/xls/data" )
public class XLSGenerationServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/vnd.ms-excel"); //mimetype	
		resp.setCharacterEncoding("UTF-8");
		resp.setHeader("Content-Disposition", "attachment;filename=profile.xls");
		PrintWriter out=resp.getWriter();
		out.write("""
				Name\tAge\tSalary\t\n
				Lebron\t78\t5000.00\n
				Jobert\t31\t5000.00\n
				Faker\t1\t5000.00\n
				
				""");

	}

}
