package com.galaxyt.capricorn.mybatisplus;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.galaxyt.capricorn.mybatisplus",exclude= DruidDataSourceAutoConfigure.class)
@MapperScan("com.galaxyt.capricorn.mybatisplus.dao")
public class MybatisPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisPlusApplication.class, args);
	}


}
