package com.example.eurekacode9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaCode9Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaCode9Application.class, args);
	}

}
