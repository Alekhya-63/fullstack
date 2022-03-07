package com.linkedin.linkedinProject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories(basePackages="com.linkedin.linkedinProject.repository")
@SpringBootApplication
public class LinkedinProjectApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(LinkedinProjectApplication.class, args);

	}

}