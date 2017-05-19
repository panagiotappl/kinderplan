package com;

import com.webapplication.controllers.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses = UserController.class)
@SpringBootApplication
@ComponentScan(basePackageClasses = UserController.class)

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
