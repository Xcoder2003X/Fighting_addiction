package com.example.dicipline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DiciplineApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiciplineApplication.class, args);
	}

}
