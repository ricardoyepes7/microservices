package com.tutorial.bikemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BikeMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikeMicroserviceApplication.class, args);
	}

}
