package net.devstudy.ishop.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.devstudy.ishop.service.impl.ServiceManager;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@WebListener
public class IShopApplicationListener implements ServletContextListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(IShopApplicationListener.class);
	private ServiceManager serviceManager;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			serviceManager = ServiceManager.getInstance(sce.getServletContext());
		} catch (RuntimeException e) {
			LOGGER.error("Web application 'ishop' init failed: "+e.getMessage(), e);
			throw e;
		}
		LOGGER.info("Web application 'ishop' initialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		serviceManager.close();
		LOGGER.info("Web application 'ishop' destroyed");
	}
}
