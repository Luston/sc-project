package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class ScZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScZuulApplication.class, args);
	}

}
