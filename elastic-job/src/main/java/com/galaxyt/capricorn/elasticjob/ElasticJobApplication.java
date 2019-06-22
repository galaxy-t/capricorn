package com.galaxyt.capricorn.elasticjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.galaxyt.capricorn.elasticjob")
public class ElasticJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticJobApplication.class, args);
	}


}
