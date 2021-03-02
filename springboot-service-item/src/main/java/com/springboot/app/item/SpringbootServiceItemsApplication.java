package com.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@RibbonClient(name = "servicio-productos")
@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
public class SpringbootServiceItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceItemsApplication.class, args);
	}

}
