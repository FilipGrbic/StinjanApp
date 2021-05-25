package com.panonit.StinjanApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ComponentScan({"com.panonit.StinjanApp", "com.panonit.StinjanApp.controllers","com.panonit.StinjanApp.services"})
@EntityScan("com.panonit.StinjanApp.models")
@EnableJpaRepositories("com.panonit.StinjanApp.repositories")
@SpringBootApplication
public class StinjanAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StinjanAppApplication.class, args);
	}
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

}
