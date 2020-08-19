package com.spring.reactive.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LoanReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanReactiveApplication.class, args);
	}
}
