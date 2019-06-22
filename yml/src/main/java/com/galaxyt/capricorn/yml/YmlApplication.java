package com.galaxyt.capricorn.yml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.galaxyt.capricorn.yml")

public class YmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(YmlApplication.class, args);
	}


}
