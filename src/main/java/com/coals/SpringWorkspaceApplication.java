package com.coals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.*")
@SpringBootApplication
public class SpringWorkspaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWorkspaceApplication.class, args);
	}
	
	

}
