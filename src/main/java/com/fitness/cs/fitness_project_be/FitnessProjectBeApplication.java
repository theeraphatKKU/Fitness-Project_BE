package com.fitness.cs.fitness_project_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.fitness.cs")
public class FitnessProjectBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnessProjectBeApplication.class, args);
		System.out.println("Start");
	}

}
