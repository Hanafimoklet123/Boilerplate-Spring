package com.boilerplate.spring;

import com.boilerplate.spring.entity.Roles;
import com.boilerplate.spring.repository.RolesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BoilerplateSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoilerplateSpringApplication.class, args);
	}


}
