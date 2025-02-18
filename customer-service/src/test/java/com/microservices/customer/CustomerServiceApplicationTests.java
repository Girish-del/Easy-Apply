package com.microservices.customer;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerServiceApplicationTests {

	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static{
		mongoDBContainer.start();
	}

	@Test
	void shouldCreateCustomer() {
		String requestBody = """
				{
				    "firstName": "mitesh",
				    "lastName": "parab",
				    "userName": "mparab",
				    "email": "mitesh@gmail.com",
				    "description": "He is my friend"
				}
				""";

		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.when()
				.post("/api/customer")
				.then()
				.statusCode(201)
				.body("id", Matchers.notNullValue())
				.body("firstName", Matchers.equalTo("mitesh"))
				.body("lastName", Matchers.equalTo("parab"))
				.body("userName", Matchers.equalTo("mparab"))
				.body("email", Matchers.equalTo("mitesh@gmail.com"))
				.body("description", Matchers.equalTo("He is my friend"));
	}

}
