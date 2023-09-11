package com.shop.now.ms.shop.now.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ShopNowRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopNowRegistryApplication.class, args);
	}

}
