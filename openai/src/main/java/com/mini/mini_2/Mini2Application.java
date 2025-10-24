package com.mini.mini_2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

@EnableFeignClients
@SpringBootApplication
public class Mini2Application {
	public static void main(String[] args) {
		SpringApplication.run(Mini2Application.class, args);
	}
}