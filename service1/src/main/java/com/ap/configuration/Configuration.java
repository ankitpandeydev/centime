package com.ap.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@org.springframework.context.annotation.Configuration
public class Configuration {
	
	@Bean
	public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption,
			@Value("${application-version}") String appVersion) {

		return new OpenAPI().info(new Info().title("sample application API").version("v1")
				.description("Assignment service").termsOfService("http://swagger.io/terms/")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

   @Bean 
   public RestTemplate restTemplate() {
	   
	   return new RestTemplate();
   }
}
