package com.mini.mini_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class Mini2Application {
	public static void main(String[] args) {
		SpringApplication.run(Mini2Application.class, args);
	}
}