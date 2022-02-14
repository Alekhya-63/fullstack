package com.linkedin.linkedinProject;

//package com.in28minutes.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories(basePackages="com.linkedin.linkedinProject.repository")
///@ComponentScan(basePackages = {"com.linkedin.linkedinProject"})
@SpringBootApplication
public class LinkedinProjectApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(LinkedinProjectApplication.class, args);

	}

}