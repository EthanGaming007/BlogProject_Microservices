package com.serverservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerServiceApplication.class, args);
	}

}
//We can mark our ServerServiceApplication with @EnableEurekaServer annotation;
//due to this, this act like a server so all the microservices will register here.

//Eureka server job is, the port number once registered in Eureka server, it updates the port number
//for all the other places automatically.

// All the port number of microservices will register in eureka server if i change the port number
// then the eureka server will update change (port number) everywhere.

//after running this application we go and search http://localhost:8761 what we get that no one microservices is registered there,
//so we have to register our both post and comment server on this ,after that it will act like a global registry book.

//Eureka server is done lets get eureka client.