package com.spring.demospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.spring.demospring.config.WebSecurityConfig;

@ComponentScan (basePackages = "com.spring.demospring,com.spring.demospring.repository")
@EnableJpaRepositories
@SpringBootApplication
public class DemoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);
	}

}
