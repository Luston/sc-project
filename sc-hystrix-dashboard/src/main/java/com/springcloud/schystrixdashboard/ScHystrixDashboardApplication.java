package com.springcloud.schystrixdashboard;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication
public class ScHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScHystrixDashboardApplication.class, args);
	}

}
