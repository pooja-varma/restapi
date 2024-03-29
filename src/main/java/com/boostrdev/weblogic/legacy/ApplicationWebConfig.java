package com.boostrdev.weblogic.legacy;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ApplicationWebConfig extends WebMvcConfigurerAdapter{
	@Override
	public void addResourceHandlers (ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").
				addResourceLocations("classpath:/static/");
	}
}
