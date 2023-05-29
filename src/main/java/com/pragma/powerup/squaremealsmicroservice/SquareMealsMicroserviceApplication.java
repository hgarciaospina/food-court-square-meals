package com.pragma.powerup.squaremealsmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class SquareMealsMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SquareMealsMicroserviceApplication.class, args);
	}

}
