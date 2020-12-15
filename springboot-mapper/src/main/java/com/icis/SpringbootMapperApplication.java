package com.icis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.icis.mapper")
public class SpringbootMapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMapperApplication.class, args);
	}

}
