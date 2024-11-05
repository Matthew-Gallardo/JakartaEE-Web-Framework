package org.acumen.training.codes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DiagramLoaderServlet", urlPatterns = "/load/diagram")
public class DiagramLoaderServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/jpeg");
		String rootContext = req.getServletContext().getRealPath(File.separator);
		File img= new File(rootContext +"/img/kape.jpg");
		BufferedImage bi= ImageIO.read(img);
		ServletOutputStream out= resp.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		out.close();
	}

}
