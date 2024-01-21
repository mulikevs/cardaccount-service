package com.sitemapdev.cardaccountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info =@Info(
				title ="Card Account Rest APIS",
				version ="0.0.1",
				description ="CRUD API"
				)
		)
public class CardaccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardaccountServiceApplication.class, args);
	}

}
