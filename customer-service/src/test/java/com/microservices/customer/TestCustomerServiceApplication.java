package com.microservices.customer;

import org.springframework.boot.SpringApplication;

public class TestCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(CustomerServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
