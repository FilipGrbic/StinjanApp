package com.panonit.StinjanApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.panonit.StinjanApp.controllers"})
@EntityScan("com.panonit.StinjanApp.models")
@EnableJpaRepositories("com.panonit.StinjanApp.repositories")
@SpringBootApplication
public class StinjanAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StinjanAppApplication.class, args);
	}

}
