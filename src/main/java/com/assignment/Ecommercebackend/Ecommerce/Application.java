package com.assignment.Ecommercebackend.Ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan("com.assignment.Ecommercebackend.Ecommerce.Cart")
//@EnableJpaRepositories("com.assignment.Ecommercebackend.Ecommerce.Cart")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

