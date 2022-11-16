package com.java.springmvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//tuong tu cho web.xml
//cach 1 implements interface

/*
 * public class WebInitializer implements WebApplicationInitializer {
 * 
 * public void onStartup(ServletContext container) throws ServletException {
 * AnnotationConfigWebApplicationContext ctx = new
 * AnnotationConfigWebApplicationContext();
 * ctx.register(HelloWorldConfiguration.class);
 * ctx.setServletContext(container); ServletRegistration.Dynamic servlet =
 * container.addServlet("dispatcher", new DispatcherServlet(ctx));
 * servlet.setLoadOnStartup(1); servlet.addMapping("/"); }
 * 
 * }
 */
//cach 2
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {HelloWorldConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
}
