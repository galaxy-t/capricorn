package com.galaxyt.capricorn.mongodb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.galaxyt.capricorn.mongodb")
public class MongoDBApplication {


    public static void main(String[] args) {
        SpringApplication.run(MongoDBApplication.class, args);
    }

}
