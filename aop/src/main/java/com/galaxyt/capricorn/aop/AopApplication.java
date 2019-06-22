package com.galaxyt.capricorn.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.galaxyt.capricorn.aop")
public class AopApplication {

    public static void main(String[] args) {
        System.setProperty("env", "FAT");
        SpringApplication.run(AopApplication.class, args);
    }

}
