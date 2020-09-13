package com.example.token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class TokenApplication {

	
	Logger log = LoggerFactory.getLogger(TokenApplication.class);
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(TokenApplication.class, args);
	}

}
