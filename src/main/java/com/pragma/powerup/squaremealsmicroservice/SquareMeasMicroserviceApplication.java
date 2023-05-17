package com.pragma.powerup.squaremealsmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class SquareMeasMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SquareMeasMicroserviceApplication.class, args);
	}

}
