package com.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //it will register it as a client
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
//The purpose of these project is it can route our incoming request to the required microservices with one URl one port.

//Advantages
//1- It does not need multiple ports.
//2-All your spring security everything we can implement it on a gateway.

