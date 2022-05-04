package com.app.cinefilia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CinefiliaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinefiliaApplication.class, args);
	}

}
