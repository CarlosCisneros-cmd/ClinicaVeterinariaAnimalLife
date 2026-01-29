package com.uisrael.apiALconsumo.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
	
	@Bean
	WebClient webcliente(WebClient.Builder builder) {
		return builder.baseUrl("http://localhost:8080/api").build();
	}

}
