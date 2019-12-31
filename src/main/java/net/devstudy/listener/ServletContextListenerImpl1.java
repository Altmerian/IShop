package net.devstudy.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextListenerImpl1 implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -> ServletContextListenerImpl1");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		sce.getServletContext();
	}
}
