package net.devstudy.config;

import java.util.Set;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import net.devstudy.filter.SimpleFilter3;
import net.devstudy.listener.ServletContextListenerImpl3;
import net.devstudy.servlet.JavaConfigServlet;

public class ApplicationConfigInitializer implements ServletContainerInitializer {
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		JavaConfigServlet servlet = new JavaConfigServlet();
		ServletRegistration.Dynamic servletConfig = ctx.addServlet("JavaConfigServlet", servlet);
		servletConfig.addMapping("/java");
		System.out.println("ApplicationConfigInitializer");

		FilterRegistration.Dynamic filterConfig = ctx.addFilter("SimpleFilter3", new SimpleFilter3());
		filterConfig.addMappingForUrlPatterns(null, true, "/*");
		
		ctx.addListener(new ServletContextListenerImpl3());
	}
}
