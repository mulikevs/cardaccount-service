package com.sitemapdev.cardaccountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	    info = @Info(
	        title = "Card Account Micro Service REST APIs",
	        version = "0.0.1",
	        description = "CRUD API for managing cards and accounts",
	        contact = @Contact(
	            name = "Kelvin M. Mwau",
	            email = "kelvinmmwau@gmail.com",
	            url = "https://portfolio.sitemapdev.co.ke/"
	        )
	    )
	)

public class CardaccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardaccountServiceApplication.class, args);
	}

}
