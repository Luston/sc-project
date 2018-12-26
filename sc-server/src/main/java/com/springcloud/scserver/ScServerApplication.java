package com.springcloud.scserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ScServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScServerApplication.class, args);
	}
}
