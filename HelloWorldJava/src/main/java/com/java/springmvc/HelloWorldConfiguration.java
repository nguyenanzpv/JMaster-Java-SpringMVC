package com.java.springmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration //khai bao day la file cau hinh
@EnableWebMvc //cho phep spring su dung cac annotation de cau hinh
@ComponentScan(basePackages = "com.java.springmvc") //scan trong package
//tuong tu spring-servlet.xml
public class HelloWorldConfiguration {
	@Bean //khai bao day la 1 bean can ioc khoi tao va luu giu
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
}
