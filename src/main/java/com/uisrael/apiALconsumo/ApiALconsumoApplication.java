package com.uisrael.apiALconsumo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean; 
import org.springframework.web.client.RestTemplate; 

@SpringBootApplication()
public class ApiALconsumoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiALconsumoApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
