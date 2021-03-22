package com.reactivetodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class ReactiveTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveTodoApplication.class, args);
	}

}
