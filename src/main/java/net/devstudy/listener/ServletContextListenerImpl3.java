package net.devstudy.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerImpl3 implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -> ServletContextListenerImpl3");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		sce.getServletContext();
	}
}
