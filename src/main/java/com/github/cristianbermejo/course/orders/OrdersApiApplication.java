package com.github.cristianbermejo.course.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {
		"com.github.cristianbermejo.course.orders.controller",
		"com.github.cristianbermejo.course.orders.service"
})
@EnableJpaRepositories(basePackages = "com.github.cristianbermejo.course.orders.dao")
@EntityScan
public class OrdersApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersApiApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate template() {
		return new RestTemplate();
	}

}
