package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
@RefreshScope
public class ScZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScZuulApplication.class, args);
	}

}
