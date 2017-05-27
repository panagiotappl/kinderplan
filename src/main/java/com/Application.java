package com;

import com.webapplication.dao.UserRepository;
import com.webapplication.entity.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
    public CommandLineRunner loadData(UserRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Users(1,"a@a.com","Jack", "Bauer","123","Parents",true));
			repository.save(new Users(2,"a@a.gr","Chloe", "O'Brian","321","Providers",true));
		};
	}

}
