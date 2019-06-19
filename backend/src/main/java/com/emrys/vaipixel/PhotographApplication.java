package com.emrys.vaipixel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.emrys.vaipixel.db.mapper")
public class PhotographApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotographApplication.class, args);
	}

}
