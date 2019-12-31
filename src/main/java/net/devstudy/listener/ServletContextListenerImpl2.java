package net.devstudy.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerImpl2 implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -> ServletContextListenerImpl2");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		sce.getServletContext();
	}
}
