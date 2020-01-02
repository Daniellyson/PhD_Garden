package com.spring.henallux.phD_Garden;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class PhDGardenApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhDGardenApplication.class, args);
	}

}
