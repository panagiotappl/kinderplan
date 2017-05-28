package com;

import com.webapplication.config.CustomUserDetails;
import com.webapplication.dao.AdminRepository;
import com.webapplication.dao.ParentRepository;
import com.webapplication.dao.ProviderRepository;
import com.webapplication.entities.Admin;
import com.webapplication.entities.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
    public CommandLineRunner loadData(AdminRepository repository,ParentRepository parentRepository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Admin(1L,"user","123"));
			parentRepository.save(new Parent(1L,"parent","123"));
		};
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, ParentRepository parentRepository, ProviderRepository providerRepository,AdminRepository adminRepository) throws Exception {
		builder.userDetailsService(new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
				if(parentRepository.findByEmail(email) != null){
					return new CustomUserDetails(parentRepository.findByEmail(email));
				}else if(providerRepository.findByEmail(email) != null){
					return new CustomUserDetails(providerRepository.findByEmail(email));
				}else{
					return new CustomUserDetails(adminRepository.findByEmail(email));
				}

			}
		});
	}

}
