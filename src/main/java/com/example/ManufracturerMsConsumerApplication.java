package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ManufracturerMsConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManufracturerMsConsumerApplication.class, args);
	}
}