package com.egg.news;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsApplication.class, args);
	}
	@Bean
	public OpenAPI OpenAPI(){
		return new OpenAPI().info(new Info().
				title("Egg News ApiRest").
				version("1.0").description("News management systrem by Robert Claros Dev ").termsOfService("hhtp:/swagger.io/terms/"));
	}
}
