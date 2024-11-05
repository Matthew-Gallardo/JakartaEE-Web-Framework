package org.acumen.training.codes.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class MessageListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String message = " Hello World Listerner";
		ServletContext context = sce.getServletContext();
		context.setAttribute("message", message);
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}
}
