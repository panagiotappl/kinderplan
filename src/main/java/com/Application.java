package com;

import com.webapplication.dao.ParentRepository;
import com.webapplication.dao.ProviderRepository;
import com.webapplication.dao.UserRepository;
import com.webapplication.entity.ParentEntity;
import com.webapplication.entity.ProviderEntity;
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
	public CommandLineRunner loadData(UserRepository repository, ParentRepository parentRepository, ProviderRepository providerRepository) {
		return (args) -> {
//			// save a couple of customers
			UserEntity user = new UserEntity("a@a.com","Jack", "Bauer","123","parent",true);
		repository.save(user);

			ParentEntity parentEntity = new ParentEntity();
			parentEntity.setPoints(20);
			parentEntity.setUser(user);
			parentRepository.save(parentEntity);
//
//			user = new UserEntity("b@b.com","Nathan", "Drake","123","provider",true);
//			repository.save(user);
//
//			ProviderEntity providerEntity = new ProviderEntity();
//			providerEntity.setCompanyName("Hercules");
//			providerEntity.setVatNumber(42123875);
//			providerEntity.setUser(user);
//			providerRepository.save(providerEntity);
		};
	}

}
