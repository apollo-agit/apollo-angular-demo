package com.inertia.solutions.apollo.item.mvc.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * 
 * Simple context configuration for the "Web" portion since we 
 * want to separate the web context from the application context. Though
 * we have provided a context listener.
 * 
 * @author Ian Hamilton
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.inertia.solutions.apollo.item.mvc.web.controller", 
		"com.inertia.solutions.apollo.item.mvc.rest.controller"})
public class WebContext {
	
	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver returnVal = new InternalResourceViewResolver();
		returnVal.setViewClass(JstlView.class);
		returnVal.setPrefix("/WEB-INF/jsp/");
		returnVal.setSuffix(".jsp");
		return returnVal;
	}

}
