package com.galaxyt.capricorn.user;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 *
 *
 *
 * @author zhouqi
 * @date 2019-06-14 17:01
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-14 17:01     zhouqi          v1.0.0           Created
 *
 */
@SpringBootApplication(scanBasePackages = "com.galaxyt.capricorn",exclude= DruidDataSourceAutoConfigure.class)
@EnableFeignClients(basePackages = "com.galaxyt.capricorn.core.service")
@MapperScan("com.galaxyt.capricorn.user.dao")
@EnableHystrix
@EnableCircuitBreaker	//开启断路器
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}


}
