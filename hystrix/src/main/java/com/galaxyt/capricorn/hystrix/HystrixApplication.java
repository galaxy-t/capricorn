package com.galaxyt.capricorn.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.galaxyt.capricorn.hystrix")
@EnableFeignClients(basePackages = "com.galaxyt.capricorn.hystrix.inter")
@EnableHystrix    //开启熔断器，仅本地，无法为Feign提供熔断器
public class HystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixApplication.class, args);
	}


}
