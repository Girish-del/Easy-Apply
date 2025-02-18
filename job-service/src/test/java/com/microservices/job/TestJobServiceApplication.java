package com.microservices.job;

import org.springframework.boot.SpringApplication;

public class TestJobServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(JobServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
