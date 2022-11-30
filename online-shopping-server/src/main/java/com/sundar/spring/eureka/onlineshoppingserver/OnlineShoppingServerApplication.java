package com.sundar.spring.eureka.onlineshoppingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OnlineShoppingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineShoppingServerApplication.class, args);
	}

}
