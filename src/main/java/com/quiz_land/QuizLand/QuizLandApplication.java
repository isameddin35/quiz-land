package com.quiz_land.QuizLand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.quiz_land")
@SpringBootApplication
@ComponentScan(basePackages = "com.quiz_land")
@EnableJpaRepositories(basePackages = "com.quiz_land.repository")
public class QuizLandApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizLandApplication.class, args);
	}

}
