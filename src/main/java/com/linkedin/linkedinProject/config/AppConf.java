package com.linkedin.linkedinProject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConf implements WebMvcConfigurer{

	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedOrigins("http://localhost:4200",
	                        "http:localhost:9381")
	                .allowedMethods("GET","POST","DELETE", "PUT");
	    }
}
