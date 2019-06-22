package com.galaxyt.capricorn.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.galaxyt.capricorn.apollo")
public class ApolloApplication {

	public static void main(String[] args) {
		System.setProperty("env", "FAT");
		SpringApplication.run(ApolloApplication.class, args);
	}


}
