package org.acumen.training.codes.listener;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
@WebListener
public class GenderOptionsListener implements ServletContextListener {
	private List<String> gender;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		gender = new ArrayList<>();
		gender.add("male");
		gender.add("female");
		sce.getServletContext().setAttribute("gender", gender);
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		gender=null;
	}

}
