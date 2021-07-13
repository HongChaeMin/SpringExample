package com.coals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.*") // com. 으로 시작하는 패키지를 다 둘러본다
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class SpringWorkspaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWorkspaceApplication.class, args);
	}

}
