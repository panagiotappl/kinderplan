package com;

import com.webapplication.dao.ParentRepository;
import com.webapplication.dao.UserRepository;
import com.webapplication.entity.ParentEntity;
import com.webapplication.entity.UserEntity;
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
    public CommandLineRunner loadData(UserRepository repository, ParentRepository parentRepository) {
		return (args) -> {
			// save a couple of customers
			UserEntity user = new UserEntity("a@a.com","Jack", "Bauer","123","ParentEntity",true);
			repository.save(user);
			//repository.save(new UserEntity("a@a.gr","Chloe", "O'Brian","321","ProviderEntity",true));
		    ParentEntity parentEntity = new ParentEntity();
		    parentEntity.setPoints(20);
		    parentEntity.setUser(user);
		    parentRepository.save(parentEntity);
		};
	}

}
